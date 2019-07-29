package com.training.payments.service;

import com.training.payments.model.Payment;

import java.util.List;

public interface PaymentService {

    /**
     * Find all payments.
     * @return List of Payments.
     */
    List<Payment> findAll();

    /**
     * Find all payments by category Id.
     * @param categoryId Category Id.
     * @return List of Payments.
     */
    List<Payment> findByCategoryId(Integer categoryId);

    /**
     * Find payment by Id.
     * @param paymentId Payment Id.
     * @return Payment object.
     */
    Payment findById(Integer paymentId);

    /**
     * Find payment by Payment Name.
     * @param paymentName Payment Name.
     * @return Payment object.
     */
    Payment findByName(String paymentName);

    /**
     * Add Payment.
     * @param payment Payment.
     */
    void add(Payment payment);

    /**
     * Update Payment.
     * @param payment Payment.
     */
    void update(Payment payment);

    /**
     * Remove Payment by Id.
     * @param paymentId Payment Id.
     */
    void delete(Integer paymentId);
}
