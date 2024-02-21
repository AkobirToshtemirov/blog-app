package com.akobir.blogapp.dto;

import java.util.Date;

public record LikeDTO(
        Long likeId,
        Long userId,
        Long postId,
        boolean liked,
        Date createdAt
) {
}
