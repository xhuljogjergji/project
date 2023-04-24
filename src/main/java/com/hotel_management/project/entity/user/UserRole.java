package com.hotel_management.project.entity.user;

import com.hotel_management.project.exception.HotelManagementException;
import lombok.AllArgsConstructor;

import java.util.Arrays;
@AllArgsConstructor
public enum UserRole {
    ADMIN ("ADMIN"),
    RECEPTIONIST("RECEPSIONIST"),
    GUEST("GUEST");
    private String value;

    public static UserRole fromValue(String userRole){
        return Arrays.asList(UserRole.values())
                .stream().filter(r -> r.value.equals(userRole))
                .findFirst()
                .orElseThrow(()-> new HotelManagementException(String
                        .format("Role %s not found",userRole)));
    }

    public String getValue() {
        return value;
    }
}
