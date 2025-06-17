// RegisterRequest.java
package com.Touristra.config.security.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;

    @NotBlank
    private String phoneNumber; // Changed to lowercase p for consistency

    @NotBlank
    private String nationality;
}