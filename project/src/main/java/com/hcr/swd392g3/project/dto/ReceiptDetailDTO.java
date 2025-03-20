package com.hcr.swd392g3.project.dto;

import javax.persistence.*;

import com.hcr.swd392g3.project.entity.Menu;
import com.hcr.swd392g3.project.entity.Receipt;

import java.util.List;

public class ReceiptDetailDTO {

	private int receiptDetailID;

	private int tax;

	private float discountPercentage;

	private int quantity;

//    private Receipt receipt;
//
	private Menu menu;

	public ReceiptDetailDTO() {
	}

	public ReceiptDetailDTO(int receiptDetailID, int tax, float discountPercentage, int quantity, Menu menu) {
		this.receiptDetailID = receiptDetailID;
		this.tax = tax;
		this.discountPercentage = discountPercentage;
		this.quantity = quantity;
		this.menu = menu;
	}
	
	public ReceiptDetailDTO(int tax, float discountPercentage, int quantity, Menu menu) {
		this.tax = tax;
		this.discountPercentage = discountPercentage;
		this.quantity = quantity;
		this.menu = menu;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public float getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public int getReceiptDetailID() {
		return receiptDetailID;
	}

	public void setReceiptDetailID(int receiptDetailID) {
		this.receiptDetailID = receiptDetailID;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
