package com.hotel_management.project.entity.room;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
@Builder
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private boolean available;

    @Column(nullable = false)
    private BigDecimal pricePerNight;
    @OneToMany(mappedBy = "room",fetch =FetchType.LAZY,cascade = CascadeType.ALL)
    private List<RoomOption> roomOptions;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private RoomCategory roomCategory;

    public Room(String name
            , int capacity
            , boolean available
            , BigDecimal pricePerNight
            , List<RoomOption> roomOptions
            , RoomCategory roomCategory) {
        this.name = name;
        this.capacity = capacity;
        this.available = available;
        this.pricePerNight = pricePerNight;
        this.roomOptions = roomOptions;
        this.roomCategory = roomCategory;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", available=" + available +
                ", pricePerNight=" + pricePerNight +
                ", roomOptions=" + roomOptions +
                ", roomCategory=" + roomCategory +
                '}';
    }
}
