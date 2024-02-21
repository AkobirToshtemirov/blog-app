package com.akobir.blogapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PostCreateDTO(
        @NotNull(message = "User ID must not be null")
        Long userId,

        @NotBlank(message = "Title must not be blank")
        @Size(min = 3)
        String title,

        @NotBlank(message = "Content must not be blank")
        String content
) {
}
