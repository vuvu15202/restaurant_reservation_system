package com.hcr.swd392g3.project.controller;

import com.hcr.swd392g3.project.dto.TableDTO;
import com.hcr.swd392g3.project.dto.WaitlistDTO;
import com.hcr.swd392g3.project.entity.Waitlist;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.hcr.swd392g3.project.service.IService.ITableService;
import com.hcr.swd392g3.project.service.IService.IWailistService;

import java.util.List;

@RestController
@RequestMapping("employee")
public class WaitlistController {

    @Autowired
    IWailistService service;


    @GetMapping(value = "/customerwaitlists")
    public ResponseEntity<?> getAllByPersonID(){
        return new ResponseEntity<List<WaitlistDTO>>(service.getAllByPersonID(), HttpStatus.OK);
    }
    @GetMapping(value = "/waitlists")
    public ResponseEntity<?> getAllWaitlist(){

        return new ResponseEntity<List<WaitlistDTO>>(service.getAll(),HttpStatus.OK);
    }
    @PostMapping(value = "/addwaitlist")
    public ResponseEntity<?> addWaitlist(@ModelAttribute WaitlistDTO waitlistDTO){
        service.addWaitlist(waitlistDTO);
        return new ResponseEntity<WaitlistDTO>(waitlistDTO,HttpStatus.OK);
    }


	
	@RequestMapping(value = "/waitlistpage")
	public ModelAndView loadtablepage() {
		return new ModelAndView("employee-waitlistpage");
	}

}
