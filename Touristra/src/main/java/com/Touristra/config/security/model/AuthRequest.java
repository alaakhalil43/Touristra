// AuthRequest.java
package com.Touristra.config.security.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
   

}