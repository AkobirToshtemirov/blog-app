package com.akobir.blogapp.mapper;

import com.akobir.blogapp.dto.LikeDTO;
import com.akobir.blogapp.entity.Like;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LikeMapper {

    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    @Mapping(target = "likeId", source = "like.likeId")
    @Mapping(target = "userId", source = "like.user.userId")
    @Mapping(target = "postId", source = "like.post.postId")
    LikeDTO toDTO(Like like);

    @Mapping(target = "likeId", source = "likeDTO.likeId")
    @Mapping(target = "user.userId", source = "likeDTO.userId")
    @Mapping(target = "post.postId", source = "likeDTO.postId")
    Like toEntity(LikeDTO likeDTO);
}
