package com.hotel_management.project.controller;

import com.hotel_management.project.entity.Invoice;
import com.hotel_management.project.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable Integer id) {
        invoiceService.deleteInvoiceById(id);
    }
    @GetMapping("{id}")
    public ResponseEntity<Invoice>getInvoiceById(@PathVariable("id")Integer id){
        return new ResponseEntity<Invoice>(invoiceService.getInvoiceById(id).get(), HttpStatus.OK);
    }
}
