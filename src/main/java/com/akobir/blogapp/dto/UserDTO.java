package com.akobir.blogapp.dto;

import java.util.Date;

public record UserDTO(
        String username,
        String email,
        Date createdAt
) {
}
