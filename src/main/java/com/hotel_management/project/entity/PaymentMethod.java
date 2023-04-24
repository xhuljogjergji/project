package com.hotel_management.project.entity;

import com.hotel_management.project.exception.HotelManagementException;
import lombok.AllArgsConstructor;

import java.util.Arrays;
@AllArgsConstructor
public enum PaymentMethod {
    COD("COD"),
    CARD("CARD"),
    PAYPAL("PAYPAL");

    private String value;

    public static PaymentMethod fromValue(String value){
        return Arrays.asList(PaymentMethod.values())
                .stream().filter(r -> r.value.equals(value))
                .findFirst()
                .orElseThrow(()-> new HotelManagementException(String
                        .format("Shipping Status %s not found",value)));
    }

    public String getValue() {
        return value;
    }
}
