package com.training.model;

/**
 * Class contains categories for payments.
 *
 * @author Mikhail Horychau
 *
 * @version 1.0.0-SNAPSHOT
 */

public class Category {
    /**
     * Category Id.
     */
    private Integer categoryId;
    /**
     * Category Name.
     */
    private String categoryName;

    /**
     * Get this category id.
     * @return Category Id.
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * Set this category id.
     * @param id Category Id.
     */
    public void setCategoryId(final Integer id) {
        this.categoryId = id;
    }

    /**
     * Get this category name.
     * @return Category Name.
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Set name of this category.
     * @param name Category Name.
     */
    public void setCategoryName(final String name) {
        this.categoryName = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return "Category{"
                + "categoryId=" + categoryId
                + ", categoryName=" + categoryName
                + '}';
    }
}
