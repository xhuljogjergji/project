package com.hotel_management.project.entity;


import com.hotel_management.project.entity.user.User;
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
@Table(name = "invoices")
@Builder
@Data
public class Invoice{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private boolean paid;

    @ManyToOne(optional = false)
    private Reservation reservation;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    private int stayingdays;

    public Invoice(BigDecimal amount, boolean paid, Reservation reservation, User user,int stayingdays) {
        this.amount = amount;
        this.paid = paid;
        this.reservation = reservation;
      this.user=user;
      this.stayingdays=stayingdays;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", amount=" + amount +
                ", paid=" + paid +
                ", reservation=" + reservation +
                ", user=" + user +
                '}';
    }
}