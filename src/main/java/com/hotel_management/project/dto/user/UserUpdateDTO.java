package com.hotel_management.project.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateDTO {
    private Integer id;
    @NotNull(message = "Name is required")
    private String firstName;
    @NotNull(message = "Surname is required")
    @NotEmpty(message ="username cannot be empty")
    private String lastName;
    @NotNull(message = "Email is required")
    @Email(message = "Email is not valid format")
    private String email;
}
