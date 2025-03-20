package com.hcr.swd392g3.project.repository;

import com.hcr.swd392g3.project.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
