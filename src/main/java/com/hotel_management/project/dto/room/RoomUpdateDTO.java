package com.hotel_management.project.dto.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomUpdateDTO {
    private Integer id;

    private String name;

    private int capacity;

    private boolean available;

    private BigDecimal pricePerNight;
}
