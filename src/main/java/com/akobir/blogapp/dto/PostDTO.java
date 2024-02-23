package com.akobir.blogapp.dto;

import java.time.LocalDateTime;

public record PostDTO(
        Long postId,
        Long userId,
        String title,
        String content,
        LocalDateTime createdAt
) {
}
