package com.hotel_management.project.dto.user;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Integer id;
    @NotNull(message = "First name is required")
    private String firstName;
    @NotNull(message = "Last name is required")
    private String lastName;
    @NotNull(message = "Email is required")
    @Email(message = "Email is not valid ")
    private String email;
    @NotNull(message = "Password is required")
    private String password;
    @NotNull(message = "Phone number is required")
    private Integer phoneNo;
}
