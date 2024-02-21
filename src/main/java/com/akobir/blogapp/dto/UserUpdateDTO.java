package com.akobir.blogapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserUpdateDTO(
        @NotBlank(message = "Username must not be blank")
        @Size(min = 3)
        String username,

        @Email(message = "Invalid email format")
        String email
) {
}
