package com.training.payments.service;

import com.training.payments.model.Category;

import java.util.List;

public interface CategoryService {
    /**
     * Find all categories list.
     * @return list of categories.
     */
    List<Category> findAll();

    /**
     * Find category by Id.
     * @param categoryId Category Id.
     * @return Category object.
     */
    Category findById(Integer categoryId);

    /**
     * Find category by Name.
     * @param categoryName Category Name.
     * @return Category object.
     */
    Category findByName(String categoryName);

    /**
     * Add category in database.
     * @param category Category.
     */
    void add(Category category);

    /**
     * Update category.
     * @param category Category.
     */
    void update(Category category);

    /**
     * Delete category by Id.
     * @param categoryId Category Id.
     */
    void delete(Integer categoryId);
}
