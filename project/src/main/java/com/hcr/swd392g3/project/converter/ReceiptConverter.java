package com.hcr.swd392g3.project.converter;

import org.springframework.stereotype.Component;

import com.hcr.swd392g3.project.dto.ReceiptDTO;
import com.hcr.swd392g3.project.entity.Receipt;


@Component
public class ReceiptConverter {

    //convert from dto into entity
    public Receipt toEntity(ReceiptDTO dto) {
        Receipt entity = new Receipt();
        entity.setReceiptID(dto.getReceiptID());
        entity.setBookingHour(dto.getBookingHour());
        entity.setDemand(dto.isDemand());
        entity.setStatus(dto.isStatus());
        entity.setCustomer(dto.getCustomer());

        return entity;
    }

    //convert from entity into dto
    public ReceiptDTO toDTO(Receipt entity) {
        ReceiptDTO dto = new ReceiptDTO();
        dto.setReceiptID(entity.getReceiptID());
        dto.setBookingHour(entity.getBookingHour());
        dto.setDemand(entity.isDemand());
        dto.setStatus(entity.isStatus());
        dto.setCustomer(entity.getCustomer());

        if(entity.getReceiptDetailList()!=null) {
        	dto.setReceiptDetail(entity.getReceiptDetailList());
        }
        return dto;
    }

    //convert from dto into entity
    public Receipt toEntity(ReceiptDTO dto, Receipt entity) {
    	entity.setReceiptID(dto.getReceiptID());
        entity.setBookingHour(dto.getBookingHour());
        entity.setDemand(dto.isDemand());
        entity.setStatus(dto.isStatus());
        entity.setCustomer(dto.getCustomer());
        return entity;
    }
}
