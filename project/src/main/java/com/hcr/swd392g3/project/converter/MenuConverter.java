package com.hcr.swd392g3.project.converter;

import org.springframework.stereotype.Component;

import com.hcr.swd392g3.project.dto.MenuDTO;
import com.hcr.swd392g3.project.entity.Menu;


@Component
public class MenuConverter {

    //convert from dto into entity
    public Menu toEntity(MenuDTO dto) {
        Menu entity = new Menu();
        entity.setMenuID(dto.getMenuID());
        entity.setDishName(dto.getDishName());
        entity.setUnitPrice(dto.getUnitPrice());
        entity.setAvailability(dto.isAvailability());
        entity.setRecipe(dto.getRecipe());
        entity.setNote(dto.getNote());
        entity.setImage(dto.getImage());
        return entity;
    }

    //convert from entity into dto
    public MenuDTO toDTO(Menu entity) {
        MenuDTO dto = new MenuDTO();
        dto.setMenuID(entity.getMenuID());
        dto.setDishName(entity.getDishName());
        dto.setUnitPrice(entity.getUnitPrice());
        dto.setAvailability(entity.isAvailability());
        dto.setRecipe(entity.getRecipe());
        dto.setNote(entity.getNote());
        dto.setImage(entity.getImage());
        return dto;
    }

    //convert from dto into entity
    public Menu toEntity(MenuDTO dto, Menu entity) {
        entity.setMenuID(dto.getMenuID());
        entity.setDishName(dto.getDishName());
        entity.setUnitPrice(dto.getUnitPrice());
        entity.setAvailability(dto.isAvailability());
        entity.setRecipe(dto.getRecipe());
        entity.setNote(dto.getNote());
        entity.setImage(dto.getImage());
        return entity;
    }
}
