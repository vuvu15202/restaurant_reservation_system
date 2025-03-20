package com.hcr.swd392g3.project.converter;

import org.springframework.stereotype.Component;

import com.hcr.swd392g3.project.dto.WaitlistDTO;
import com.hcr.swd392g3.project.entity.Waitlist;


@Component
public class WaitlistConverter {

    //convert from dto into entity
    public Waitlist toEntity(WaitlistDTO dto) {
        Waitlist entity = new Waitlist();
        entity.setPerson(dto.getPerson());
        entity.setTable(dto.getTable());
        entity.setBookingHour(dto.getBookingHour());
        return entity;
    }

    //convert from entity into dto
    public WaitlistDTO toDTO(Waitlist entity) {
        WaitlistDTO dto = new WaitlistDTO();
        dto.setPerson(entity.getPerson());
        dto.setTable(entity.getTable());
        dto.setBookingHour(entity.getBookingHour());
        return dto;
    }

    //convert from dto into entity
    public Waitlist toEntity(WaitlistDTO dto, Waitlist entity) {
        entity.setPerson(dto.getPerson());
        entity.setTable(dto.getTable());
        entity.setBookingHour(dto.getBookingHour());
        return entity;
    }
}
