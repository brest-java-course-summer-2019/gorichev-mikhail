package com.training.payments.dao;

import com.training.payments.model.Category;

import java.util.List;
import java.util.Optional;

/**
 * Category DAO interface.
 */
public interface CategoryDao {

    /**
     * Persist new Category.
     * @param category new category.
     * @return new category object.
     */
    Category add(Category category);

    /**
     * Update category.
     * @param category category.
     */
    void update(Category category);

    /**
     * Delete category with specified id.
     * @param categoryId category Id.
     */
    void delete(Integer categoryId);

    /**
     * Get all categories.
     * @return categories list.
     */
    List<Category> findAll();

    /**
     * Get category by name.
     * @param name category name.
     * @return Category object.
     */
    Optional<Category> findByName(String name);

    /**
     * Get category by specified Id.
     * @param categoryId category Id.
     * @return Category object.
     */
    Optional<Category> findById(Integer categoryId);
}
