package com.hotel_management.project.service;

import com.hotel_management.project.dto.InvoiceDTO;
import com.hotel_management.project.entity.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {
   Invoice findById(Integer id);

    void deleteInvoiceById(Integer id);
    Optional<Invoice> getInvoiceById(Integer id);
}
