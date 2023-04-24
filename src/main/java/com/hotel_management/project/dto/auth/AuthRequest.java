package com.hotel_management.project.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthRequest {
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
}
