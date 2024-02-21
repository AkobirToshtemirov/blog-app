package com.akobir.blogapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Data Transfer Object (DTO) representing a request to register a new user.
 */
public record UserCreateDTO(
        @NotBlank(message = "Username must not be blank")
        @Size(min = 3)
        String username,

        @NotBlank(message = "Password must not be blank") @Size(min = 8, message = "Password must be at least 8 characters long")
        String password,

        @NotBlank(message = "Email must not be blank") @Email(message = "Invalid email format")
        String email
) {
}
