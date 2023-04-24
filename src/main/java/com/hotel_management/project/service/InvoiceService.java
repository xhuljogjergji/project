package com.hotel_management.project.service;

import com.hotel_management.project.dto.InvoiceDTO;
import com.hotel_management.project.entity.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {
   Invoice findById(Integer id);

    InvoiceDTO deleteInvoiceById(Integer id);
    InvoiceDTO updateInvoice(Integer id, InvoiceDTO invoiceDTO);

    Optional<Invoice> getInvoiceById(Integer id);
}
