package com.hcr.swd392g3.project.dto;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.hcr.swd392g3.project.entity.Person;

public class EmployeeDTO extends PersonDTO{


    private String contract;

    private Date hiredDate;

    private float salary;

    private String department;


    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
