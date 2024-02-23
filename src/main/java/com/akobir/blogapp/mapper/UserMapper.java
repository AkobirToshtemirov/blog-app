package com.akobir.blogapp.mapper;

import com.akobir.blogapp.dto.UserCreateDTO;
import com.akobir.blogapp.dto.UserDTO;
import com.akobir.blogapp.dto.UserUpdateDTO;
import com.akobir.blogapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);

    default void updateUserFromDTO(UserUpdateDTO userDTO, User user) {
        if (userDTO.username() != null) {
            user.setUsername(userDTO.username());
        }
        if (userDTO.email() != null) {
            user.setEmail(userDTO.email());
        }
    }

    User fromCreateDTO(UserCreateDTO dto);
}