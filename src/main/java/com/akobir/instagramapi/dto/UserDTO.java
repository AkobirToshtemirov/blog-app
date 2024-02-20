package com.akobir.instagramapi.dto;

import java.util.Date;

public record UserDTO(
        String username,
        String email,
        String profileImage,
        Date createdAt
) {
}
