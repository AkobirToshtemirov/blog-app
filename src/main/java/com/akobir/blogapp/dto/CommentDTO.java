package com.akobir.blogapp.dto;

import java.time.LocalDateTime;

public record CommentDTO(
        Long commentId,
        Long postId,
        Long userId,
        String content,
        LocalDateTime createdAt
) {
}
