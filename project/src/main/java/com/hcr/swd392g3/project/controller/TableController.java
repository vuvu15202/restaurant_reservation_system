package com.hcr.swd392g3.project.controller;


import com.hcr.swd392g3.project.converter.TableConverter;
import com.hcr.swd392g3.project.dto.TableDTO;
import com.hcr.swd392g3.project.entity.Table;
import com.hcr.swd392g3.project.service.IService.ITableService;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

@CrossOrigin
@RestController
@RequestMapping("employee")
public class TableController {

    @Autowired
    ITableService tableService;

    @Autowired
    private TableConverter tableConverter;

    //load table page
    @GetMapping(value = "/tablepage")
    public ModelAndView loadtablepage() {
        return new ModelAndView("employee-tablepage");
    }

    //    get all table
    @GetMapping(value = "/table")
    public ResponseEntity<?> getAllTable() {
        return new ResponseEntity<List<TableDTO>>(tableService.getAllTable(), HttpStatus.OK);
    }

    //    get table by id
    @GetMapping(value = "/table/{id}")
    public ResponseEntity<?> getTableByID(@PathVariable("id") int id) {
        return new ResponseEntity<TableDTO>(tableService.getTableByID(id), HttpStatus.OK);
    }

    // insert table
    //@modelatribute use for content-type mutipart/form-data
    @PostMapping(value = "/table")
    public TableDTO createTable(@ModelAttribute @Valid @RequestBody Table table) {
        return tableService.saveTable(tableConverter.toDTO(table));
    }

    //update table
    @PutMapping(value = "/table")
    public TableDTO updateTable(@RequestBody TableDTO model) {
        return tableService.updateTable(model);
    }

    //    delete table by id
    @DeleteMapping(value = "/table/{id}")
    public void deleteTable(@PathVariable("id") int id) {
        tableService.delete(id);
    }
}
