package com.akobir.blogapp.mapper;

import com.akobir.blogapp.dto.PostDTO;
import com.akobir.blogapp.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "postId", source = "id")
    PostDTO postToPostDTO(Post post);

    @Mapping(target = "id", source = "postId")
    Post postDTOToPost(PostDTO postDTO);
}
