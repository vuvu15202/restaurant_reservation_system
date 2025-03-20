package com.hcr.swd392g3.project.converter;

import org.springframework.stereotype.Component;

import com.hcr.swd392g3.project.dto.EmployeeDTO;
import com.hcr.swd392g3.project.entity.Employee;

@Component
public class EmployeeConverter {
	//convert from dto into entity
	public Employee toEntity(EmployeeDTO dto) {
		Employee entity = new Employee();
		entity.setContract(dto.getContract());
		entity.setHiredDate(dto.getHiredDate());
		entity.setSalary(dto.getSalary());
		entity.setDepartment(dto.getDepartment());
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
	public EmployeeDTO toDTO(Employee entity) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setContract(entity.getContract());
		dto.setHiredDate(entity.getHiredDate());
		dto.setSalary(entity.getSalary());
		dto.setDepartment(entity.getDepartment());
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
	
	//convert from dto into entity
	public Employee toEntity(EmployeeDTO dto, Employee entity) {
		entity.setContract(dto.getContract());
		entity.setHiredDate(dto.getHiredDate());
		entity.setSalary(dto.getSalary());
		entity.setDepartment(dto.getDepartment());
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

}
