package com.hcr.swd392g3.project.service;

import com.hcr.swd392g3.project.controller.MenuController;
import com.hcr.swd392g3.project.converter.MenuConverter;
import com.hcr.swd392g3.project.dto.MenuDTO;
import com.hcr.swd392g3.project.dto.TableDTO;
import com.hcr.swd392g3.project.entity.Menu;
import com.hcr.swd392g3.project.repository.MenuRepository;
import com.hcr.swd392g3.project.service.IService.IMenuService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    MenuConverter menuConverter;

    @Autowired
    MenuRepository menuRepo;


    @Override
    public List<MenuDTO> getAllMenu() {
        List<MenuDTO> dtoList = new ArrayList<>();
        List<Menu> entityList = menuRepo.findAll();
        for (Menu temp : entityList) {
            dtoList.add(menuConverter.toDTO(temp));
        }
        return dtoList;
    }

    @Override
    public MenuDTO getMenuByID(int id) {
        return menuConverter.toDTO(menuRepo.findOneByMenuID(id));
    }
}
