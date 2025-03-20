package com.hcr.swd392g3.project.entity;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Employee")
@DiscriminatorValue("employee")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "empSuper", discriminatorType = DiscriminatorType.STRING)
public class Employee extends Person {

//	@Id
//    @NotNull
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "employeeID")
//	private int employeeID;

    @Column(name = "Contract")
    private String contract;

    @Column(name = "hiredDate")
    private Date hiredDate;

    @Column(name = "Salary")
    private float salary;

    @Column(name = "Department")
    private String department;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Receipt> receiptList;


//    public int getEmployeeID() {
//        return employeeID;
//    }
//
//    public void setEmployeeID(int employeeID) {
//        this.employeeID = employeeID;
//    }

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

    public List<Receipt> getReceiptList() {
        return receiptList;
    }

    public void setReceiptList(List<Receipt> receiptList) {
        this.receiptList = receiptList;
    }


//        public static void main(String[] args)
//        {
//            Employee ad = new Employee();
//        }

}
