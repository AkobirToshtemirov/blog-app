package com.akobir.blogapp.mapper;

import com.akobir.blogapp.dto.CommentDTO;
import com.akobir.blogapp.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "commentId", source = "comment.commentId")
    @Mapping(target = "postId", source = "comment.post.postId")
    @Mapping(target = "userId", source = "comment.user.userId")
    CommentDTO toDTO(Comment comment);

    @Mapping(target = "commentId", source = "commentDTO.commentId")
    @Mapping(target = "post.postId", source = "commentDTO.postId")
    @Mapping(target = "user.userId", source = "commentDTO.userId")
    Comment toEntity(CommentDTO commentDTO);
}
