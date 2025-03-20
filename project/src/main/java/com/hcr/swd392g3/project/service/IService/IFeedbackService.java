package com.hcr.swd392g3.project.service.IService;

import java.util.List;

import com.hcr.swd392g3.project.dto.FeedbackDTO;


public interface IFeedbackService {
    FeedbackDTO saveFeedback(FeedbackDTO feedbackDTO);
	FeedbackDTO updateFeedback(FeedbackDTO feedbackDTO);
    List<FeedbackDTO> getAllFeedback();
}