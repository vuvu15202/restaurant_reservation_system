package com.hcr.swd392g3.project.controller;

import com.hcr.swd392g3.project.dto.CustomerDTO;
import com.hcr.swd392g3.project.dto.PersonDTO;
import com.hcr.swd392g3.project.service.IService.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class CustomerController {

    @Autowired
    ICustomerService service;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody CustomerDTO user) throws Exception {
        return ResponseEntity.ok(service.saveCustomer(user));
    }
    
    @RequestMapping(value = "/customer/profile", method = RequestMethod.GET)
    public ResponseEntity<?> getProfile() throws Exception {
        return ResponseEntity.ok(service.getProfileByUserName(getAuthorizationName()));
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
