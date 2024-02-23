package com.akobir.blogapp.service.impl;

import com.akobir.blogapp.dto.UserCreateDTO;
import com.akobir.blogapp.dto.UserDTO;
import com.akobir.blogapp.dto.UserUpdateDTO;
import com.akobir.blogapp.entity.User;
import com.akobir.blogapp.exception.NotFoundException;
import com.akobir.blogapp.mapper.UserMapper;
import com.akobir.blogapp.repository.UserRepository;
import com.akobir.blogapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));
        return userMapper.INSTANCE.toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        User user = userMapper.INSTANCE.fromCreateDTO(userCreateDTO);
        User savedUser = userRepository.save(user);

        return userMapper.INSTANCE.toDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(Long userId, UserUpdateDTO userUpdateDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));

        userMapper.INSTANCE.updateUserFromDTO(userUpdateDTO, user);

        User updatedUser = userRepository.save(user);
        return userMapper.INSTANCE.toDTO(updatedUser);
    }


    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
