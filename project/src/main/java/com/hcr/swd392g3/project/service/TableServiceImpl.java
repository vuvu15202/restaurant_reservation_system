package com.hcr.swd392g3.project.service;


import com.hcr.swd392g3.project.converter.TableConverter;
import com.hcr.swd392g3.project.dto.TableDTO;
import com.hcr.swd392g3.project.entity.Table;
import com.hcr.swd392g3.project.repository.TableRepository;
import com.hcr.swd392g3.project.service.IService.ITableService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImpl implements ITableService {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private TableConverter tableConverter;

    @Override
    public TableDTO saveTable(TableDTO dto) {
        Table newTable = new Table();
        if (dto.getTableID() > 0) {
            Table oldTable = tableRepository.findOneByTableID(dto.getTableID());
            if (oldTable == null) {
                // abc
            }

            Table oldInfor = tableRepository.findOneByTableID(dto.getTableID());
            newTable = tableConverter.toEntity(dto, oldTable);
        } else {
            newTable = tableConverter.toEntity(dto);
        }
        newTable = tableRepository.save(newTable);
        return tableConverter.toDTO(newTable);
    }

    @Override
    public TableDTO updateTable(TableDTO dto) {
        Table oldInfor = tableRepository.findOneByTableID(dto.getTableID());
        Table newTable = tableConverter.toEntity(dto, oldInfor);
        newTable = tableRepository.save(newTable);
        return tableConverter.toDTO(newTable);
    }

    @Override
    public void delete(int id) {
        tableRepository.deleteById(id);
    }

    @Override
    public TableDTO changeTableStatus(TableDTO dto) {
        Table oldInfor = tableRepository.findOneByTableID(dto.getTableID());
        oldInfor.setStatus(dto.getStatus());
        Table newTable = tableRepository.save(oldInfor);
        return tableConverter.toDTO(newTable);
    }

    @Override
    public List<TableDTO> getAllTable() {
        List<TableDTO> dtoList = new ArrayList<>();
        List<Table> entityList = tableRepository.findAll();
        for (Table temp : entityList) {
            dtoList.add(tableConverter.toDTO(temp));
        }
        return dtoList;
    }

    @Override
    public TableDTO getTableByID(int id) {
        return tableConverter.toDTO(tableRepository.findOneByTableID(id));
    }
}
