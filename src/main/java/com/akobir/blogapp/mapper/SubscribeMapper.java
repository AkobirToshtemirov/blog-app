package com.akobir.blogapp.mapper;

import com.akobir.blogapp.dto.SubscribeDTO;
import com.akobir.blogapp.entity.Subscribe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SubscribeMapper {

    SubscribeMapper INSTANCE = Mappers.getMapper(SubscribeMapper.class);

    @Mapping(target = "subscribeId", source = "subscribe.subscribeId")
    @Mapping(target = "followerUserId", source = "subscribe.followerUser.userId")
    @Mapping(target = "followingUserId", source = "subscribe.followingUser.userId")
    SubscribeDTO toDTO(Subscribe subscribe);

    @Mapping(target = "subscribeId", source = "subscribeDTO.subscribeId")
    @Mapping(target = "followerUser.userId", source = "subscribeDTO.followerUserId")
    @Mapping(target = "followingUser.userId", source = "subscribeDTO.followingUserId")
    Subscribe toEntity(SubscribeDTO subscribeDTO);
}
