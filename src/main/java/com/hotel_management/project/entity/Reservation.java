package com.hotel_management.project.entity;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
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

    @Column
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate checkInDate;

    @Column
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate checkOutDate;

    @Column(nullable = false)
    private int numberOfGuests;

    @ManyToOne(optional = false)
    private User user;
    private String reservationName;
    private String customerEmail;
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", room=" + room +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", numberOfGuests=" + numberOfGuests +
                ", user=" + user +
                ", reservationName='" + reservationName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }

    public Reservation(Room room, LocalDate checkInDate, LocalDate checkOutDate,
                       int numberOfGuests, User user, String reservationName, String customerEmail) {
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfGuests = numberOfGuests;
        this.user = user;
        this.reservationName = reservationName;
        this.customerEmail = customerEmail;
    }

}
