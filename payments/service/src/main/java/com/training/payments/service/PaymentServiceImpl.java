package com.training.payments.service;

import com.training.payments.dao.PaymentDao;
import com.training.payments.model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    private PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public List<Payment> findAll() {
        LOGGER.debug("Find all categories");
        return paymentDao.findAll();
    }

    @Override
    public List<Payment> findByCategoryId(Integer categoryId) {
        LOGGER.debug("Find payment by categoryId({})", categoryId);
        return paymentDao.findByCategoryId(categoryId);
    }

    @Override
    public Payment findById(Integer paymentId) {
        LOGGER.debug("Find payment by Id({})", paymentId);
        return paymentDao.findById(paymentId).
                orElseThrow(() -> new RuntimeException("Failed to get payment from DataBase"));
    }

    @Override
    public Payment findByName(String paymentName) {
        LOGGER.debug("Find payment by Name({})", paymentName);
        return paymentDao.findByName(paymentName)
                .orElseThrow(() -> new RuntimeException("Failed to get payment from DataBase"));
    }

    @Override
    public void add(Payment payment) {
        LOGGER.debug("Add payment({})", payment);
        paymentDao.add(payment);
    }

    @Override
    public void update(Payment payment) {
        LOGGER.debug("Update Payment ({})", payment);
        paymentDao.update(payment);
    }

    @Override
    public void delete(Integer paymentId) {
        LOGGER.debug("Delete Payment by Id({})", paymentId);
        paymentDao.delete(paymentId);
    }
}
