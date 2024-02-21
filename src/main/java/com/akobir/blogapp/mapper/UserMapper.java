package com.akobir.blogapp.mapper;

import com.akobir.blogapp.dto.UserDTO;
import com.akobir.blogapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "userId", source = "id")
    UserDTO userToUserDTO(User user);

    @Mapping(target = "id", source = "userId")
    User userDTOToUser(UserDTO userDTO);

    void updateUserFromDTO(UserDTO userDTO, @MappingTarget User user);
}
