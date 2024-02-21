package com.akobir.blogapp.service;

import com.akobir.blogapp.dto.CommentCreateDTO;
import com.akobir.blogapp.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    List<CommentDTO> getCommentsByPostId(Long postId);

    CommentDTO createComment(CommentCreateDTO commentCreateDTO);

    CommentDTO updateComment(Long commentId, String newContent);

    void deleteComment(Long commentId);
}
