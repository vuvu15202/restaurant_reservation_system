package com.hcr.swd392g3.project.entity;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "Menu")
public class Menu {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuID;

    @Column(name = "DishName")
    private String dishName;

    @Column(name = "UnitPrice")
    private int unitPrice;

    @Column(name = "Availability")
    private boolean availability;

    @Column(name = "Recipe")
    private String recipe;

    @Column(name = "Image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Category category;

    @Column(name = "Note")
    private String note;
    @JsonIgnore
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<ReceiptDetail> receiptDetailList;


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

    public void setDishName(String name) {
        this.dishName = name;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ReceiptDetail> getReceiptDetailList() {
        return receiptDetailList;
    }

    public void setReceiptDetailList(List<ReceiptDetail> receiptDetailList) {
        this.receiptDetailList = receiptDetailList;
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
