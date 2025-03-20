package com.hcr.swd392g3.project.service.IService;

import com.hcr.swd392g3.project.dto.CustomerDTO;
import org.springframework.stereotype.Service;


public interface ICustomerService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CustomerDTO getProfileByUserName(String userName);

}
