package com.hotel_management.project.repository;

import com.hotel_management.project.entity.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
    List<Room> findByAvailable(boolean available);

    List<Room> findByCapacityGreaterThanEqual(int capacity);

    List<Room> findByPricePerNightLessThanEqual(BigDecimal maxPrice);
}
