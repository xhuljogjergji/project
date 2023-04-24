package com.hotel_management.project.controller;

import com.hotel_management.project.dto.InvoiceDTO;
import com.hotel_management.project.entity.Invoice;
import com.hotel_management.project.entity.Reservation;
import com.hotel_management.project.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestControllerAdvice
@RequiredArgsConstructor
@RequestMapping("/invoices")
public class InvoiceController {

private final InvoiceService invoiceService;

    @GetMapping("/{id}")
    public Optional<Invoice> findById(@PathVariable Integer id) {
        return Optional.ofNullable(invoiceService.findById(id));
    }

    @PutMapping("/{id}")
    public InvoiceDTO updateInvoice(@PathVariable Integer id, @RequestBody InvoiceDTO invoiceDTO) {
        return invoiceService.updateInvoice(id, invoiceDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable Integer id) {
        invoiceService.deleteInvoiceById(id);
    }
}
