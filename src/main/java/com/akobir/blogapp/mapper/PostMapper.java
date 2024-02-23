package com.akobir.blogapp.mapper;

import com.akobir.blogapp.dto.PostDTO;
import com.akobir.blogapp.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

//    @Mapping(target = "userId", source = "user.userId")
//    @Mapping(target = "postId", source = "post.postId")
    PostDTO toDTO(Post post);

//    @Mapping(target = "user.userId", source = "postDTO.userId")
//    @Mapping(target = "postId", source = "postDTO.postId")
    Post toEntity(PostDTO postDTO);
}
