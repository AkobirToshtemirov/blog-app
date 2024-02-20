package com.akobir.instagramapi.dto;

import java.util.Date;

public record CommentDTO(
        Long commentId,
        Long postId,
        Long userId,
        String content,
        Date createdAt
) {
}
