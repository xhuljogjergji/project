package com.hotel_management.project.entity;


import com.hotel_management.project.entity.room.Room;
import com.hotel_management.project.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private Room room;

    @Column(nullable = false)
    private LocalDate checkInDate;

    @Column(nullable = false)
    private LocalDate checkOutDate;

    @Column(nullable = false)
    private int numberOfGuests;

    @ManyToOne(optional = false)
    private User user;

    public Reservation(Room room,
                       LocalDate checkInDate,
                       LocalDate checkOutDate,
                       int numberOfGuests,
                       User user) {
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfGuests = numberOfGuests;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", room=" + room +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", numberOfGuests=" + numberOfGuests +
                ", user=" + user +
                '}';
    }
}
