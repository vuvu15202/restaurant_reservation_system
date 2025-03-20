package com.hcr.swd392g3.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcr.swd392g3.project.converter.FeedbackConverter;
import com.hcr.swd392g3.project.dto.FeedbackDTO;
import com.hcr.swd392g3.project.entity.Feedback;
import com.hcr.swd392g3.project.service.IService.IFeedbackService;

@RestController
@RequestMapping("customer")
public class FeedbackController {

    @Autowired
    IFeedbackService service;

    @Autowired
    private FeedbackConverter feedbackConverter;

    @GetMapping(value = "/myorder")
    public ModelAndView loadFeeback() {
        return new ModelAndView("customer-myorderpage");
    }

    @GetMapping(value = "/feedback")
    public ResponseEntity<?> getAllFeedback() {
    	
      return new ResponseEntity<List<FeedbackDTO>>(service.getAllFeedback(), HttpStatus.OK);
    }

    // insert table
    //@modelatribute use for content-type mutipart/form-data
    @PostMapping(value = "/feedback")
    public FeedbackDTO createFeedback(@ModelAttribute @Valid @RequestBody Feedback feeback) {
        return service.saveFeedback(feedbackConverter.toDTO(feeback));
    }

    //update table
    @PutMapping(value = "/feedback")
    public FeedbackDTO updateFeedback(@RequestBody FeedbackDTO model) {
        return service.updateFeedback(model);
    }
    
    public String getAuthorizationName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails)principal).getUsername();
        } else {
            return principal.toString();
        }
    }
}
