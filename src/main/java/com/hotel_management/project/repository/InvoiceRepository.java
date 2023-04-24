package com.hotel_management.project.repository;

import com.hotel_management.project.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    List<Invoice> findByPaid(boolean paid);
    Optional<Invoice> findById(Integer id);

     Optional<Invoice> findById(Invoice byId);
}
