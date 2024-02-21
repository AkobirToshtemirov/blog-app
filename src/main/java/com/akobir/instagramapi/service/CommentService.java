package com.akobir.instagramapi.service;

import com.akobir.instagramapi.dto.CommentCreateDTO;
import com.akobir.instagramapi.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    List<CommentDTO> getCommentsByPostId(Long postId);

    CommentDTO createComment(CommentCreateDTO commentCreateDTO);

    CommentDTO updateComment(Long commentId, String newContent);

    void deleteComment(Long commentId);
}
