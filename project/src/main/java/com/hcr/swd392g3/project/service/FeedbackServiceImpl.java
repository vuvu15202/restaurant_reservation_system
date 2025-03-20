package com.hcr.swd392g3.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcr.swd392g3.project.converter.FeedbackConverter;
import com.hcr.swd392g3.project.dto.FeedbackDTO;
import com.hcr.swd392g3.project.entity.Feedback;
import com.hcr.swd392g3.project.repository.FeedbackRepository;
import com.hcr.swd392g3.project.service.IService.IFeedbackService;

@Service
public class FeedbackServiceImpl implements IFeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackConverter feedbackConverter;

    @Override
    public FeedbackDTO saveFeedback(FeedbackDTO dto) {
        Feedback newFeedback = new Feedback();
        if (dto.getFeedbackID() > 0) {
            Feedback oldFeedback = feedbackRepository.findOneByFeedbackID(dto.getFeedbackID());
            if (oldFeedback == null) {
                // abc
            }

            Feedback oldInfor = feedbackRepository.findOneByFeedbackID(dto.getFeedbackID());
            newFeedback = feedbackConverter.toEntity(dto, oldFeedback);
        } else {
            newFeedback = feedbackConverter.toEntity(dto);
        }
        newFeedback = feedbackRepository.save(newFeedback);
        return feedbackConverter.toDTO(newFeedback);
    }

    @Override
    public FeedbackDTO updateFeedback(FeedbackDTO dto) {
        Feedback oldInfor = feedbackRepository.findOneByFeedbackID(dto.getFeedbackID());
        Feedback newFeedback = feedbackConverter.toEntity(dto, oldInfor);
        newFeedback = feedbackRepository.save(newFeedback);
        return feedbackConverter.toDTO(newFeedback);
    }

    @Override
	public List<FeedbackDTO> getAllFeedback() { 
		List<FeedbackDTO> dtoList = new ArrayList<>();
		List<Feedback> entityList = feedbackRepository.findAll();
        for (Feedback temp : entityList) {
            dtoList.add(feedbackConverter.toDTO(temp));
            
        }
        return dtoList;
	}
}