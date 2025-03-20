package com.hcr.swd392g3.project.service;

import com.hcr.swd392g3.project.repository.CategoryRepository;
import com.hcr.swd392g3.project.service.IService.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryRepository repos;

}
