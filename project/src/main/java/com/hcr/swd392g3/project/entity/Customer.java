package com.hcr.swd392g3.project.entity;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "Customer")
@DiscriminatorValue("customer")
public class Customer extends Person {
    //	@Id
//    @NotNull
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "customerID")
//    private int customerID;

    @Column(name = "Loyalty")
    private boolean loyalty;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Receipt> receiptList;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Feedback> feedbackList;


    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public List<Receipt> getReceiptList() {
        return receiptList;
    }

    public void setReceiptList(List<Receipt> receiptList) {
        this.receiptList = receiptList;
    }

    public boolean isLoyalty() {
        return loyalty;
    }

    public void setLoyalty(boolean loyalty) {
        this.loyalty = loyalty;
    }


}
