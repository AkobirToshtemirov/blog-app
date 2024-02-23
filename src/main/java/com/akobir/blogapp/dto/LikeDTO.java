package com.akobir.blogapp.dto;

import java.time.LocalDateTime;

public record LikeDTO(
        Long likeId,
        Long userId,
        Long postId,
        boolean liked,
        LocalDateTime createdAt
) {
}
