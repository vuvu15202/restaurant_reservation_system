package com.hcr.swd392g3.project.dto;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

public class CategoryDTO {

    private int categoryID;

    private String categoryName;

    private String description;

//    private List<MenuDTO> menus;


//    public List<MenuDTO> getMenus() {
//		return menus;
//	}
//
//	public void setMenus(List<MenuDTO> menus) {
//		this.menus = menus;
//	}

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
