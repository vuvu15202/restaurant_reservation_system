package com.hcr.swd392g3.project.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.hcr.swd392g3.project.entity.Customer;
import com.hcr.swd392g3.project.entity.ReceiptDetail;

import java.sql.Date;


public class FeedbackDTO {

    private int feedbackID;

    private String comment;

    private int ratingStar;

    private boolean status;

    private Date feedbackDate;

//    private Customer customer;
//    
//    private ReceiptDetail receiptDetail;


    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRatingStar() {
        return ratingStar;
    }

    public void setRatingStar(int ratingStar) {
        this.ratingStar = ratingStar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }


}

