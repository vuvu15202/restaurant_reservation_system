package com.hcr.swd392g3.project.converter;

import org.springframework.stereotype.Component;

import com.hcr.swd392g3.project.dto.FeedbackDTO;
import com.hcr.swd392g3.project.entity.Feedback;


@Component
public class FeedbackConverter {

    //convert from dto into entity
    public Feedback toEntity(FeedbackDTO dto) {
        Feedback entity = new Feedback();
        entity.setFeedbackID(dto.getFeedbackID());
        entity.setComment(dto.getComment());
        entity.setRatingStar(dto.getRatingStar());
        entity.setStatus(dto.isStatus());
        entity.setFeedbackDate(dto.getFeedbackDate());
        return entity;
    }

    //convert from entity into dto
    public FeedbackDTO toDTO(Feedback entity) {
        FeedbackDTO dto = new FeedbackDTO();
        dto.setFeedbackID(entity.getFeedbackID());
        dto.setComment(entity.getComment());
        dto.setRatingStar(entity.getRatingStar());
        dto.setStatus(entity.isStatus());
        dto.setFeedbackDate(entity.getFeedbackDate());
        return dto;
    }

    //convert from dto into entity
    public Feedback toEntity(FeedbackDTO dto, Feedback entity) {
        entity.setFeedbackID(dto.getFeedbackID());
        entity.setComment(dto.getComment());
        entity.setRatingStar(dto.getRatingStar());
        entity.setStatus(dto.isStatus());
        entity.setFeedbackDate(dto.getFeedbackDate());
        return entity;
    }
}
