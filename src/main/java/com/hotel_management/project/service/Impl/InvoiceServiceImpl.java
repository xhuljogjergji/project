package com.hotel_management.project.service.Impl;

import com.hotel_management.project.dto.InvoiceDTO;
import com.hotel_management.project.entity.Invoice;
import com.hotel_management.project.exception.ResourceNotFoundException;
import com.hotel_management.project.mapper.InvoiceMapper;
import com.hotel_management.project.repository.InvoiceRepository;
import com.hotel_management.project.service.InvoiceService;
import com.hotel_management.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

import static com.hotel_management.project.configuration.SecurityConfig.getJwt;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
private final UserService userService;
private final InvoiceRepository invoiceRepository;
    @Override
    public Invoice findById(Integer id) {
        return invoiceRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Invoice with Id %s not found",id)));
    }

    @Override
    public void deleteInvoiceById(Integer id) {
        Invoice in= invoiceRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Invoice with Id %s not found",id)));
        invoiceRepository.delete(in);
    }
    @Override
    public Optional<Invoice> getInvoiceById(Integer id) {
        return Optional.ofNullable(invoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Invoice with Id %s not found", id))));    }

    @Override
    public InvoiceDTO getInvoice() {
        return InvoiceMapper.toDto((Invoice) userService.getUserFromToken(getJwt()).getInvoice());
    }

}