package com.akobir.blogapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentCreateDTO(
        @NotNull(message = "Post ID must not be null")
        Long postId,

        @NotNull(message = "User ID must not be null")
        Long userId,

        @NotBlank(message = "Content must not be blank")
        String content
) {
}
