package com.hcr.swd392g3.project.dto;

import javax.persistence.*;
import javax.persistence.Table;

import com.hcr.swd392g3.project.entity.Category;

import java.util.List;

public class MenuDTO {

    private int menuID;

    private String dishName;

    private int unitPrice;

    private boolean availability;

    private String recipe;

    private String note;

    private String image;


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }


    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
