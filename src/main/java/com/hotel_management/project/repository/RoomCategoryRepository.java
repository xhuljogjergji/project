package com.hotel_management.project.repository;

import com.hotel_management.project.entity.room.RoomCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomCategoryRepository extends JpaRepository<RoomCategory,Integer> {
}
