package com.hcr.swd392g3.project.converter;

import org.springframework.stereotype.Component;

import com.hcr.swd392g3.project.dto.TableDTO;
import com.hcr.swd392g3.project.entity.Table;


@Component
public class TableConverter {

    //convert from dto into entity
    public Table toEntity(TableDTO dto) {
        Table entity = new Table();
        entity.setTableID(dto.getTableID());
        entity.setChairNumber(dto.getChairNumber());
        entity.setFloorNo(dto.getFloorNo());
        entity.setPrivacy(dto.getPrivacy());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    //convert from entity into dto
    public TableDTO toDTO(Table entity) {
        TableDTO dto = new TableDTO();
        dto.setTableID(entity.getTableID());
        dto.setChairNumber(entity.getChairNumber());
        dto.setFloorNo(entity.getFloorNo());
        dto.setPrivacy(entity.getPrivacy());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    //convert from dto into entity
    public Table toEntity(TableDTO dto, Table entity) {
        entity.setTableID(dto.getTableID());
        entity.setChairNumber(dto.getChairNumber());
        entity.setFloorNo(dto.getFloorNo());
        entity.setPrivacy(dto.getPrivacy());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
