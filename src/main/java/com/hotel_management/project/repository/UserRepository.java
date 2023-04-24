package com.hotel_management.project.repository;

import com.hotel_management.project.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByFirstName(String firstName);

   Optional<User> findByEmail(String email);

     Optional<User> findById(Integer id);

}
