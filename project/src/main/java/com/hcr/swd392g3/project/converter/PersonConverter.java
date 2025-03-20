package com.hcr.swd392g3.project.converter;

import org.springframework.stereotype.Component;

import com.hcr.swd392g3.project.dto.PersonDTO;
import com.hcr.swd392g3.project.entity.Person;

@Component
public class PersonConverter {

	//convert from dto into entity
	public Person toEntity(PersonDTO dto) {
		Person entity = new Person();
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
	public PersonDTO toDTO(Person entity) {
		PersonDTO dto = new PersonDTO();
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
	public Person toEntity(PersonDTO dto, Person entity) {
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
