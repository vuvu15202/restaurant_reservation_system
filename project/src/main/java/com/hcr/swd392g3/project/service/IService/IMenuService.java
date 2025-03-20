package com.hcr.swd392g3.project.service.IService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcr.swd392g3.project.dto.MenuDTO;
import com.hcr.swd392g3.project.dto.TableDTO;
import com.hcr.swd392g3.project.entity.Menu;


public interface IMenuService {
    List<MenuDTO> getAllMenu();

    MenuDTO getMenuByID(int id);
}
