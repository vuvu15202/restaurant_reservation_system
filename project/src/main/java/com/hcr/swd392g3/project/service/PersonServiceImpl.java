package com.hcr.swd392g3.project.service;

import com.hcr.swd392g3.project.converter.PersonConverter;
import com.hcr.swd392g3.project.dto.PersonDTO;
import com.hcr.swd392g3.project.entity.Person;
import com.hcr.swd392g3.project.repository.PersonRepository;
import com.hcr.swd392g3.project.service.IService.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonConverter personConverter;

    @Override
    public PersonDTO findPersonByUsername(String username) {
        Person person = personRepository.findByUserName(username);
        return personConverter.toDTO(person);
    }

    @Override
    public PersonDTO findPersonByEmail(String email) {
        Person person = personRepository.findByEmail(email);
        return personConverter.toDTO(person);
    }
}
