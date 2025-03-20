
package com.hcr.swd392g3.project.entity;

import javax.annotation.sql.DataSourceDefinition;

import com.hcr.swd392g3.project.dto.MenuDTO;

public class CartItem {
    private MenuDTO product;
    private int quantity;
    private double price;

    public CartItem() {
    }

    public CartItem(MenuDTO product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public MenuDTO getMenuDTO() {
        return product;
    }

    public void setMenuDTO(MenuDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}