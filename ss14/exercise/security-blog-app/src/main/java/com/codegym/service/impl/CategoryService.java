package com.codegym.service.impl;

import com.codegym.model.Category;
import com.codegym.repository.ICategoryRepository;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return iCategoryRepository.findAllCategory();
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category.getNameCategory());
    }

    @Override
    public Category findByIdCategory(Integer id) {
        return iCategoryRepository.findByIdCategory(id);
    }

    @Override
    public void update(Category category) {
        iCategoryRepository.update(category.getNameCategory(), category.getIdCategory());
    }

    @Override
    public void delete(Integer id) {
        iCategoryRepository.delete(id);
    }

}
