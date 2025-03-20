package com.hcr.swd392g3.project.converter;

import org.springframework.stereotype.Component;

import com.hcr.swd392g3.project.dto.ReceiptDetailDTO;
import com.hcr.swd392g3.project.entity.ReceiptDetail;


@Component
public class ReceiptDetailConverter {

    //convert from dto into entity
    public ReceiptDetail toEntity(ReceiptDetailDTO dto) {
        ReceiptDetail entity = new ReceiptDetail();
        entity.setReceiptDetailID(dto.getReceiptDetailID());
        entity.setTax(dto.getTax());
        entity.setDiscountPercentage(dto.getDiscountPercentage());
        entity.setQuantity(dto.getQuantity());
        entity.setMenu(dto.getMenu());

        return entity;
    }

    //convert from entity into dto
    public ReceiptDetailDTO toDTO(ReceiptDetail entity) {
        ReceiptDetailDTO dto = new ReceiptDetailDTO();
        dto.setReceiptDetailID(entity.getReceiptDetailID());
        dto.setTax(entity.getTax());
        dto.setDiscountPercentage(entity.getDiscountPercentage());
        dto.setQuantity(entity.getQuantity());
        dto.setMenu(entity.getMenu());

        return dto;
    }

    //convert from dto into entity
    public ReceiptDetail toEntity(ReceiptDetailDTO dto, ReceiptDetail entity) {
        entity.setReceiptDetailID(dto.getReceiptDetailID());
        entity.setTax(dto.getTax());
        entity.setDiscountPercentage(dto.getDiscountPercentage());
        entity.setQuantity(dto.getQuantity());
        entity.setMenu(dto.getMenu());

        return entity;
    }
}
