package com.akobir.blogapp.mapper;

import com.akobir.blogapp.dto.CommentDTO;
import com.akobir.blogapp.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "commentId", source = "id")
    CommentDTO commentToCommentDTO(Comment comment);

    @Mapping(target = "id", source = "commentId")
    Comment commentDTOToComment(CommentDTO commentDTO);
}
