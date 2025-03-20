package com.hcr.swd392g3.project.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Manager")
@DiscriminatorValue("mana")
public class Manager extends Employee {
    //
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Qualificationsss")
    private int managerID;

    @Column(name = "Qualifications")
    private String qualifications;

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }


}
