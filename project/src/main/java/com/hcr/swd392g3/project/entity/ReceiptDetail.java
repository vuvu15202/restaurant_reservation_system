package com.hcr.swd392g3.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hcr.swd392g3.project.entity.composite.ReceiptDetailID;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "ReceiptDetail")
//@IdClass(ReceiptDetailID.class)
public class ReceiptDetail {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int receiptDetailID;

    //    @Id
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "receiptID")
    private Receipt receipt;

    //    @Id
    @ManyToOne
    @JoinColumn(name = "menuID")
    private Menu menu;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "tax")
    private int tax;

    @Column(name = "discountPercentage")
    private float discountPercentage;


    @JsonIgnore
    @OneToOne(mappedBy = "receiptDetail")
    private Feedback feedback;



	public ReceiptDetail() {
		super();
	}

	public int getReceiptDetailID() {
        return receiptDetailID;
    }

    public void setReceiptDetailID(int receiptDetailID) {
        this.receiptDetailID = receiptDetailID;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
}
