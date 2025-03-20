package com.hcr.swd392g3.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcr.swd392g3.project.dto.MenuDTO;
import com.hcr.swd392g3.project.dto.TableDTO;
import com.hcr.swd392g3.project.entity.Table;
import com.hcr.swd392g3.project.service.IService.IMenuService;

@CrossOrigin
@RestController
@RequestMapping("home")
public class HomeController {

    @Autowired
    IMenuService menuService;

    @Autowired
    private MenuController mennuConverter;


    @GetMapping(value = "")
    public ModelAndView loadtablepage() {
        return new ModelAndView("homepage");
    }

    //  get all table
    @GetMapping(value = "/menus")
    public ResponseEntity<?> getAllMenu() {
        return new ResponseEntity<List<MenuDTO>>(menuService.getAllMenu(), HttpStatus.OK);
    }

    //  get table by id
    @GetMapping(value = "/menus/{id}")
    public ResponseEntity<?> getTableByID(@PathVariable("id") int id) {
        return new ResponseEntity<MenuDTO>(menuService.getMenuByID(id), HttpStatus.OK);
    }

//  // insert table
//  //@modelatribute use for content-type mutipart/form-data
//  @PostMapping(value = "/table")
//  public TableDTO createTable ( @ModelAttribute @Valid @RequestBody Table table){
//		return tableService.saveTable(tableConverter.toDTO(table));
//  }
//  
//  //update table
//  @PutMapping(value = "/table")
//	public TableDTO updateTable( @RequestBody TableDTO model) {
//		return tableService.updateTable(model);
//	}
//  
////  delete table by id
//  @DeleteMapping(value = "/table/{id}")
//	public void deleteTable(@PathVariable("id") int id) {
//		tableService.delete(id);
//	}
}
