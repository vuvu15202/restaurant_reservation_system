package com.hcr.swd392g3.project.converter;

import com.hcr.swd392g3.project.dto.CustomerDTO;
import com.hcr.swd392g3.project.dto.EmployeeDTO;
import com.hcr.swd392g3.project.entity.Customer;
import com.hcr.swd392g3.project.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    //convert from dto into entity
    public Customer toEntity(CustomerDTO dto) {
        Customer entity = new Customer();
        entity.setLoyalty(dto.isLoyalty());
        entity.setPersonID(dto.getPersonID());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAddress(dto.getAddress());
        entity.setRole(dto.getRole());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setStatus(dto.isStatus());
        entity.setGender(dto.isGender());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setUserName(dto.getUserName());

        return entity;
    }

    //convert from entity into dto
    public CustomerDTO toDTO(Customer entity) {
        CustomerDTO dto = new CustomerDTO();
        dto.setLoyalty(entity.isLoyalty());
        dto.setPersonID(entity.getPersonID());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setAddress(entity.getAddress());
        dto.setRole(entity.getRole());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setStatus(entity.isStatus());
        dto.setGender(entity.isGender());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setUserName(entity.getUserName());
        return dto;
    }
}
