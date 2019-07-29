package com.training.payments.service;

import com.training.payments.dao.CategoryDao;
import com.training.payments.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> findAll() {
        LOGGER.debug("Find all categories");
        return categoryDao.findAll();
    }

    @Override
    public Category findById(Integer categoryId) {
        LOGGER.debug("Find category by Id({})", categoryId);
        return categoryDao.findById(categoryId).
                orElseThrow(() -> new RuntimeException("Failed to get category from DataBase"));
    }

    @Override
    public Category findByName(String categoryName) {
        LOGGER.debug("Find category by Name({})", categoryName);
        return categoryDao.findByName(categoryName)
                .orElseThrow(() -> new RuntimeException("Failed to get category from DataBase"));
    }

    @Override
    public void add(Category category) {
        LOGGER.debug("Add category({})", category);
        categoryDao.add(category);
    }

    @Override
    public void update(Category category) {
        LOGGER.debug("Update Category ({})", category);
        categoryDao.update(category);
    }

    @Override
    public void delete(Integer categoryId) {
        LOGGER.debug("Delete Category by Id({})", categoryId);
        categoryDao.delete(categoryId);
    }
}
