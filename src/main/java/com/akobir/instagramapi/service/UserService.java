package com.akobir.instagramapi.service;

import com.akobir.instagramapi.dto.UserCreateDTO;
import com.akobir.instagramapi.dto.UserDTO;
import com.akobir.instagramapi.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {
    UserDTO getUserById(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserCreateDTO userCreateDTO);

    UserDTO updateUser(Long userId, UserUpdateDTO userUpdateDTO);

    void deleteUser(Long userId);
}
