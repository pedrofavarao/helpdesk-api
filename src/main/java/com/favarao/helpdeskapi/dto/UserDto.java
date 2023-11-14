package com.favarao.helpdeskapi.dto;

import jakarta.validation.constraints.NotBlank;

public record UserDto(
        Long id,
        @NotBlank(message = "Name is required.")
        String name,
        @NotBlank(message = "User is required.")
        String user,
        @NotBlank(message = "Email is required.")
        String email,
        @NotBlank(message = "Password is required.")
        String password,
        @NotBlank(message = "Role is required.")
        String role
){}
