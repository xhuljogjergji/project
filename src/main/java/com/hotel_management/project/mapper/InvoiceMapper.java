package com.hotel_management.project.mapper;

import com.hotel_management.project.dto.InvoiceDTO;
import com.hotel_management.project.entity.Invoice;

public class InvoiceMapper {
    public static InvoiceDTO toDto(Invoice in){
        return InvoiceDTO.builder()
                .id(in.getId())
                .paid(in.isPaid())
                .amount(in.getAmount())
                .stayingDays(in.getStayingdays())
                .build();
    }
}
