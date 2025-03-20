package com.hcr.swd392g3.project.controller;

import com.hcr.swd392g3.project.dto.PersonDTO;
import com.hcr.swd392g3.project.dto.TableDTO;
import com.hcr.swd392g3.project.service.IService.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    IPersonService service;

    @PostMapping(value = "/username")
    public ResponseEntity<?> getUserByUsername(@RequestBody PersonDTO personDTO) throws Exception {
        PersonDTO person = service.findPersonByUsername(personDTO.getUserName());
        return new ResponseEntity<PersonDTO>(person, HttpStatus.OK);
    }

    @PostMapping(value = "/email")
    public ResponseEntity<?> getUserByEmail(@RequestBody PersonDTO personDTO) throws Exception {
        PersonDTO person = service.findPersonByEmail(personDTO.getEmail());
        return new ResponseEntity<PersonDTO>(person, HttpStatus.OK);
    }

}
