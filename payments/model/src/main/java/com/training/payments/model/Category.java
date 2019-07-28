package com.training.payments.model;

/**
 * POJO for categories.
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
     * Category Description.
     */
    private String categoryDescription;

    /**
     * Number of payments of this category.
     */
    private Integer paymentsCount;

    /**
     * Empty constructor.
     */
    public Category() {

    }

    /**
     * Constructor with name and description.
     * @param categoryName category name.
     * @param categoryDescription category description.
     */
    public Category(String categoryName, String categoryDescription) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

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
    public void setCategoryId(Integer id) {
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
    public void setCategoryName(String name) {
        this.categoryName = name;
    }

    /**
     * Get this category description.
     * @return category description.
     */
    public String getCategoryDescription() {
        return categoryDescription;
    }

    /**
     * Set description of this category.
     * @param categoryDescription category description.
     */
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    /**
     * Get this payments count of this category.
     * @return payments count.
     */
    public Integer getPaymentsCount() {
        return paymentsCount;
    }

    /**
     * Set payments count of this category.
     * @param paymentsCount payments count.
     */
    public void setPaymentsCount(Integer paymentsCount) {
        this.paymentsCount = paymentsCount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return "Category{"
                + "categoryId=" + categoryId
                + ", categoryName=" + categoryName
                + ", categoryDescription=" + categoryDescription
                + ", paymentsCount=" + paymentsCount
                + '}';
    }
}
