package com.hotel_management.project.entity.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms_option")
@Builder
@Data
public class RoomOption{
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int capacity;

    private boolean available;

    private BigDecimal pricePerNight;
    @ManyToOne
    @JoinColumn(name = "room_id",referencedColumnName = "id")
    private Room room;

    public RoomOption(String name
            , int capacity
            , boolean available
            , BigDecimal pricePerNight
            , Room room) {
        this.name = name;
        this.capacity = capacity;
        this.available = available;
        this.pricePerNight = pricePerNight;
        this.room = room;
    }

    @Override
    public String toString() {
        return "RoomOption{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", available=" + available +
                ", pricePerNight=" + pricePerNight +
                ", room=" + room +
                '}';
    }
}
