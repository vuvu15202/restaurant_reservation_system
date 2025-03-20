package com.hcr.swd392g3.project.repository;

import com.hcr.swd392g3.project.entity.Menu;
import com.hcr.swd392g3.project.entity.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    Menu findOneByMenuID(int tableID);

    List<Menu> findAll();
}
