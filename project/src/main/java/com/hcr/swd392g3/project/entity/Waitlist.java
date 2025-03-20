package com.hcr.swd392g3.project.entity;

import com.hcr.swd392g3.project.entity.composite.WaitlistID;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Waitlist")
@IdClass(WaitlistID.class)
public class Waitlist {
    @Id
    @ManyToOne
    @JoinColumn(name = "tableID")
    private com.hcr.swd392g3.project.entity.Table table;

    @Id
    @ManyToOne
    @JoinColumn(name = "personID")
    private Person person;

    @Column(name = "bookingHour")
    private Date bookingHour;


    public com.hcr.swd392g3.project.entity.Table getTable() {
        return table;
    }

    public void setTable(com.hcr.swd392g3.project.entity.Table table) {
        this.table = table;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getBookingHour() {
        return bookingHour;
    }

    public void setBookingHour(Date bookingHour) {
        this.bookingHour = bookingHour;
    }
}
