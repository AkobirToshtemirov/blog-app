package com.akobir.instagramapi.dto;

import jakarta.validation.constraints.NotNull;

public record LikeCreateDTO(
        @NotNull(message = "User ID must not be null")
        Long userId,

        @NotNull(message = "Post ID must not be null")
        Long postId,

        boolean liked
) {
}
