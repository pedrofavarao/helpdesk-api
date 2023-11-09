package com.favarao.helpdeskapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDto(
        @NotBlank
        Long id,
        @Size(max = 60)
        @NotBlank
        String name,
        @Email
        @NotBlank
        @Size(max = 60)
        String email,
        @NotBlank
        String role
){}
