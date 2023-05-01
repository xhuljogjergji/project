package com.hotel_management.project.entity;

import com.hotel_management.project.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

import java.util.Arrays;
@AllArgsConstructor
public enum ReservationStatus {

    CANCELLED("CANCELLED"),
    CONFIRMED("CONFIRMED"),
    IN_PROGRESS("IN_PROGRESS"),
    DELIVERED("DELIVERED");

    private String value;

    public static ReservationStatus fromValue(String orderStatus){
        return Arrays.asList(ReservationStatus.values())
                .stream().filter(r -> r.value.equals(orderStatus))
                .findFirst()
                .orElseThrow(()-> new ResourceNotFoundException(String
                        .format("Reservation Status %s not found",orderStatus)));
    }

    public String getValue() {
        return value;
    }
}
