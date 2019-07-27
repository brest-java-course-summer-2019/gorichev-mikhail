package com.training.payments.model;

/**
 * POJO for payments.
 *
 * @author Mikhail Horychau
 *
 * @version 1.0.0-SNAPSHOT
 */

import java.math.BigDecimal;

public class Payment {
    /**
     * Payment Id.
     */
    private Integer paymentId;
    /**
     * Payment Name.
     */
    private String paymentName;
    /**
     * Payment Description.
     */
    private String paymentDescription;
    /**
     * Payment Cost.
     */
    private BigDecimal paymentCost;
    /**
     * Payment Category Id.
     */
    private Integer categoryId;

    /**
     * Get this Payment Id.
     * @return Payment Id.
     */
    public Integer getPaymentId() {
        return paymentId;
    }

    /**
     * Set this Payment Id.
     * @param paymentId Payment Id.
     */
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * Get this Payment Name.
     * @return Payment Name.
     */
    public String getPaymentName() {
        return paymentName;
    }

    /**
     * Set this Payment Name.
     * @param paymentName Payment Name.
     */
    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
    /**
     * Get this Payment Description.
     * @return Payment Description.
     */
    public String getPaymentDescription() {
        return paymentDescription;
    }
    /**
     * Set this Payment Description.
     * @param paymentDescription Payment Description.
     */
    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }
    /**
     * Get this Payment Cost.
     * @return Payment Cost.
     */
    public BigDecimal getPaymentCost() {
        return paymentCost;
    }
    /**
     * Set this Payment Cost.
     * @param paymentCost Payment Cost.
     */
    public void setPaymentCost(BigDecimal paymentCost) {
        this.paymentCost = paymentCost;
    }

    /**
     * Get this Payment Category Id.
     * @return Payment Category Id.
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * Set this Payment Category Id.
     * @param categoryId Payment Category Id.
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Empty constructor.
     */
    public Payment() {
    }

    /**
     * Constructor with Name, Description, Cost & Id.
     * @param paymentName Payment Name.
     * @param paymentDescription Payment Description.
     * @param paymentCost Payment Cost.
     * @param categoryId Payment Id.
     */
    public Payment(String paymentName, String paymentDescription, BigDecimal paymentCost, Integer categoryId) {
        this.paymentName = paymentName;
        this.paymentDescription = paymentDescription;
        this.paymentCost = paymentCost;
        this.categoryId = categoryId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Payment{"
                + "paymentId=" + paymentId
                + ", paymentName='" + paymentName
                + ", paymentDescription='" + paymentDescription
                + ", paymentCost=" + paymentCost
                + ", categoryId=" + categoryId
                + '}';
    }
}
