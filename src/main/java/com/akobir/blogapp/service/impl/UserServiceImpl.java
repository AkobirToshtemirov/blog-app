package com.akobir.blogapp.service.impl;

import com.akobir.blogapp.dto.UserCreateDTO;
import com.akobir.blogapp.dto.UserDTO;
import com.akobir.blogapp.dto.UserUpdateDTO;
import com.akobir.blogapp.repository.UserRepository;
import com.akobir.blogapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO getUserById(Long userId) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        return null;
    }

    @Override
    public UserDTO updateUser(Long userId, UserUpdateDTO userUpdateDTO) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}
