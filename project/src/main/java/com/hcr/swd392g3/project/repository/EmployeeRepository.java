package com.hcr.swd392g3.project.repository;

import com.hcr.swd392g3.project.entity.Employee;
import com.hcr.swd392g3.project.entity.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAll();
    List<Employee> getAllByStatus(boolean status);

    Employee getByPersonID(int personID);
    Employee findOneByPersonID(int empID);


}
