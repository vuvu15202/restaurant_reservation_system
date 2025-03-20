package com.hcr.swd392g3.project.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hcr.swd392g3.project.entity.Customer;
import com.hcr.swd392g3.project.entity.Employee;
import com.hcr.swd392g3.project.entity.ReceiptDetail;

import java.util.Date;
import java.util.List;


public class ReceiptDTO {

    private int receiptID;

    private Date bookingHour;

    private boolean status;

    private boolean demand;

//    private com.hcr.swd392g3.project.entity.Table table;
//    
//    private Employee employee;
//
    @JsonIgnore
    private Customer customer;
    
    private List<ReceiptDetail> receiptDetail;


    public List<ReceiptDetail> getReceiptDetail() {
		return receiptDetail;
	}

	public void setReceiptDetail(List<ReceiptDetail> receiptDetail) {
		this.receiptDetail = receiptDetail;
	}

	public int getReceiptID() {
        return receiptID;
    }

    public ReceiptDTO(){}
    public ReceiptDTO( Date bookingHour, boolean status, boolean demand, Customer customer) {
		this.bookingHour = bookingHour;
		this.status = status;
		this.demand = demand;
		this.customer = customer;
	}

	public void setReceiptID(int receiptID) {
        this.receiptID = receiptID;
    }

    public Date getBookingHour() {
        return bookingHour;
    }

    public void setBookingHour(Date bookingHour) {
        this.bookingHour = bookingHour;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isDemand() {
        return demand;
    }

    public void setDemand(boolean demand) {
        this.demand = demand;
    }

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


}
