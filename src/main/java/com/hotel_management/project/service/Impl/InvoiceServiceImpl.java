package com.hotel_management.project.service.Impl;

import com.hotel_management.project.dto.InvoiceDTO;
import com.hotel_management.project.entity.Invoice;
import com.hotel_management.project.exception.ResourceNotFoundException;
import com.hotel_management.project.repository.InvoiceRepository;
import com.hotel_management.project.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

private final InvoiceRepository invoiceRepository;
    @Override
    public Invoice findById(Integer id) {
        return invoiceRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Invoice with Id %s not found",id)));
    }

    @Override
    public InvoiceDTO deleteInvoiceById(Integer id) {
        Invoice in= invoiceRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Invoice with Id %s not found",id)));
        invoiceRepository.delete(in);
        return null;
    }

    @Override
    public InvoiceDTO updateInvoice(Integer id, InvoiceDTO invoiceDTO) {
        Invoice toUpdate=invoiceRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String.
                        format("Invoice with Id %s not found",id)));
        return null;
    }

    @Override
    public Optional<Invoice> getInvoiceById(Integer id) {
        return Optional.ofNullable(invoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Invoice with Id %s not found", id))));    }

}