package com.hotel_management.project.entity.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "room_category")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RoomCategory {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "parent_id",referencedColumnName = "id")
    private RoomCategory parent;
    @OneToMany(mappedBy = "parent",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<RoomCategory> subCategories;
    @OneToMany(mappedBy = "roomCategory", fetch = FetchType.LAZY)
    private List<Room> rooms;
    @CreatedDate
    private LocalDateTime createdAt;

    public RoomCategory(String name
            , RoomCategory parent
            , List<RoomCategory> subCategories
            , List<Room> rooms
            , LocalDateTime createdAt) {
        this.name = name;
        this.parent = parent;
        this.subCategories = subCategories;
        this.rooms = rooms;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "RoomCategory{" +
                "categoryId=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                ", subCategories=" + subCategories +
                ", rooms=" + rooms +
                ", createdAt=" + createdAt +
                '}';
    }
}
