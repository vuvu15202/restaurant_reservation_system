package com.hcr.swd392g3.project.service.IService;

import com.hcr.swd392g3.project.dto.PersonDTO;
import org.springframework.stereotype.Service;


public interface IPersonService {
    PersonDTO findPersonByUsername(String username);
    PersonDTO findPersonByEmail(String email);
}
