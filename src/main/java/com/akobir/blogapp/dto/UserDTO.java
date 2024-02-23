package com.akobir.blogapp.dto;

import java.time.LocalDateTime;

public record UserDTO(
        String username,
        String email,
        LocalDateTime createdAt
) {
}

