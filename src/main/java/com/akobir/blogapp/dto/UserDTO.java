package com.akobir.blogapp.dto;

import java.time.LocalDateTime;

public record UserDTO(
        Long userId,
        String username,
        String email,
        LocalDateTime createdAt
) {
}

