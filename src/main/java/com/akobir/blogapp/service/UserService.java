package com.akobir.blogapp.service;

import com.akobir.blogapp.dto.UserCreateDTO;
import com.akobir.blogapp.dto.UserDTO;
import com.akobir.blogapp.dto.UserUpdateDTO;
import com.akobir.blogapp.entity.User;

import java.util.List;

public interface UserService {
    User getById(Long userId);

    UserDTO getUserById(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserCreateDTO userCreateDTO);

    UserDTO updateUser(Long userId, UserUpdateDTO userUpdateDTO);

    void deleteUser(Long userId);
}
