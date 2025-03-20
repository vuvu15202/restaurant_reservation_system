package com.hcr.swd392g3.project.service;

import com.hcr.swd392g3.project.converter.CustomerConverter;
import com.hcr.swd392g3.project.dto.CustomerDTO;
import com.hcr.swd392g3.project.entity.Customer;
import com.hcr.swd392g3.project.repository.CustomerRepository;
import com.hcr.swd392g3.project.service.IService.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    CustomerRepository repos;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private CustomerConverter customerConverter;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setLoyalty(customerDTO.isLoyalty());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setAddress(customerDTO.getAddress());
        customer.setRole(3);
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setStatus(true);
        customer.setGender(customerDTO.isGender());
        customer.setPassword(bcryptEncoder.encode(customerDTO.getPassword()));
        customer.setEmail(customerDTO.getEmail());
        customer.setUserName(customerDTO.getUserName());
        return customerConverter.toDTO(repos.save(customer));
    }

	@Override
	public CustomerDTO getProfileByUserName(String userName) {
		return customerConverter.toDTO(repos.findOneByUserName(userName));
	}
}
