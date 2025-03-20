package com.hcr.swd392g3.project.dto;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;


public class CustomerDTO extends PersonDTO {

    private boolean loyalty;
    private int customerID;

//    private List<ReceiptDTO> receipts;
//
//    private List<FeedbackDTO> feedbacks;


    public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public boolean isLoyalty() {
        return loyalty;
    }

    public void setLoyalty(boolean loyalty) {
        this.loyalty = loyalty;
    }


}
