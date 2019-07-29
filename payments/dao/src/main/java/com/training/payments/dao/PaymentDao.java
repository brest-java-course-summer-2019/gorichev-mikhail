package com.training.payments.dao;

import com.training.payments.model.Payment;

import java.util.List;
import java.util.Optional;

/**
 * Payment Dao interface.
 */
public interface PaymentDao {

    /**
     * Add new Payment.
     * @param payment new Payment.
     * @return new Payment object.
     */
    Payment add(Payment payment);

    /**
     * Update Payment.
     * @param payment Payment.
     */
    void update(Payment payment);

    /**
     * Delete Payment by Id.
     * @param paymentId Payment Id.
     */
    void delete(Integer paymentId);

    /**
     * Get all Payments.
     * @return List of Payments.
     */
    List<Payment> findAll();

    /**
     * Get Payment by Id.
     * @param id Payment Id.
     * @return Payment.
     */
    Optional<Payment> findById(Integer id);

    /**
     * Get Payment by Name.
     * @param name Payment Name.
     * @return
     */
    Optional<Payment> findByName(String name);

    /**
     * Get List of Payments by category id.
     * @param categoryId Category Id.
     * @return List of Payments.
     */
    List<Payment> findByCategoryId(Integer categoryId);

}
