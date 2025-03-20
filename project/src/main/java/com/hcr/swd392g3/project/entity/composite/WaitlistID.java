package com.hcr.swd392g3.project.entity.composite;

import com.hcr.swd392g3.project.entity.Person;
import com.hcr.swd392g3.project.entity.Table;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class WaitlistID implements Serializable {
    private Table table;
    private Person person;
    public WaitlistID(Table table, Person person) {
        this.table = table;
        this.person = person;
    }
    
    
}
