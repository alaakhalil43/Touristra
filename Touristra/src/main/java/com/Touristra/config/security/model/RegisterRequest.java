// RegisterRequest.java
package com.Touristra.config.security.model;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}