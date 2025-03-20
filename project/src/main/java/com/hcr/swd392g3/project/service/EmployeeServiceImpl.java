package com.hcr.swd392g3.project.service;

import com.hcr.swd392g3.project.converter.EmployeeConverter;
import com.hcr.swd392g3.project.dto.EmployeeDTO;

import com.hcr.swd392g3.project.entity.Employee;
import com.hcr.swd392g3.project.entity.Person;
import com.hcr.swd392g3.project.repository.EmployeeRepository;
import com.hcr.swd392g3.project.repository.PersonRepository;

import com.hcr.swd392g3.project.service.IService.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeConverter employeeConverter;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public List<EmployeeDTO> getAll() {
        List<EmployeeDTO> list = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {
            list.add(employeeConverter.toDTO(employee));
        }
        return list;
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {

        if(employeeRepository.findOneByPersonID(employeeDTO.getPersonID())==null){

            return null;
        }
        System.out.println(employeeDTO.getPersonID()+" "+employeeDTO.getFirstName());
        Employee defautEmployee = employeeRepository.getByPersonID(employeeDTO.getPersonID());
        employeeDTO.setPassword(defautEmployee.getPassword());
        employeeDTO.setUserName(defautEmployee.getUserName());
        Employee employee= employeeConverter.toEntity(employeeDTO);


        employeeRepository.save(employee);
        return employeeDTO;
    }

    @Override
    public void banUnbanEmployee(int id) {
        Person person = personRepository.getByPersonID(id);
        if (person.isStatus()==true){
            person.setStatus(false);
        }
        else{
            person.setStatus(true);
        }
        personRepository.save(person);
    }

    @Override

    public EmployeeDTO addEmployee( EmployeeDTO employeeDTO) {
        Employee employee= employeeConverter.toEntity(employeeDTO);
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employee.setStatus(true);
        employee.setRole(2);
        employee.setHiredDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

        employeeRepository.save(employee);
//        System.out.println(employeeDTO.getFirstName());
//        System.out.println(employeeDTO.getLastName());
//        System.out.println(employeeDTO.getPassword());
        return employeeDTO;
    }


	@Override
	public EmployeeDTO findOneByID(int id) {
        System.out.println(id);
		Employee empEntity = employeeRepository.getByPersonID(id);

		return employeeConverter.toDTO(empEntity);
	}
	
	




}
