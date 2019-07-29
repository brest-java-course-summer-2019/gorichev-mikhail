package com.training.payments.dao;

import com.training.payments.model.Payment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml"})
public class PaymentDaoJdbcImplTest {

    @Autowired
    PaymentDao paymentDao;

    private static final String CINEMA = "Cinema";
    private static final String COFFEE = "Coffee";
    private static final String NEW_PAYMENT = "New Payment";
    private static final String NEW_PAYMENT_DESCRIPTION = "New payment description.";
    private static final BigDecimal NEW_PAYMENT_COST = new BigDecimal("223.33");
    private static final String UPDATED_PAYMENT_DESCRIPTION = "Updated payment description";
    private static final String REMOVED_PAYMENT_NAME = "Removed payment";

    @Test
    public void findAll() {
        List<Payment> payments = paymentDao.findAll();
        assertNotNull(payments);
        assertTrue(payments.size() > 0);
    }

    @Test
    public void findByCategoryId() {
        List<Payment> payments = paymentDao.findByCategoryId(1);
        assertNotNull(payments);
        assertEquals(payments.size(), 2);
    }

    @Test
    public void findById() {
        Payment payment = paymentDao.findById(1).get();
        assertNotNull(payment);
        assertEquals(payment.getPaymentId().intValue(), 1);
        assertEquals(payment.getPaymentName(), CINEMA);
    }

    @Test
    public void findByName() {
        Payment payment = paymentDao.findByName(COFFEE).get();
        assertNotNull(payment);
        assertEquals(payment.getPaymentName(), COFFEE);
        assertEquals(payment.getPaymentId().intValue(), 2);
    }

    @Test
    public void addPayment() {
        Payment payment = new Payment(NEW_PAYMENT, NEW_PAYMENT_DESCRIPTION, NEW_PAYMENT_COST, 4);
        payment = paymentDao.add(payment);
        assertNotNull(payment.getPaymentId());
    }

    @Test
    public void removePayment() {
        Payment payment = new Payment(REMOVED_PAYMENT_NAME, NEW_PAYMENT_DESCRIPTION, NEW_PAYMENT_COST, 4);
        payment = paymentDao.add(payment);
        paymentDao.delete(payment.getPaymentId());
        assertEquals(paymentDao.findByName(REMOVED_PAYMENT_NAME), Optional.empty());
    }

    @Test
    public void updatePayment() {
        Payment newPayment = new Payment(REMOVED_PAYMENT_NAME, NEW_PAYMENT_DESCRIPTION, NEW_PAYMENT_COST, 4);
        newPayment = paymentDao.add(newPayment);
        newPayment.setPaymentDescription(UPDATED_PAYMENT_DESCRIPTION);
        paymentDao.update(newPayment);
        Payment updatedPayment = paymentDao.findById(newPayment.getPaymentId()).get();
        assertEquals(updatedPayment.getPaymentId(), newPayment.getPaymentId());
        assertEquals(updatedPayment.getPaymentName(), newPayment.getPaymentName());
        assertEquals(updatedPayment.getPaymentCost(), newPayment.getPaymentCost());
        assertEquals(updatedPayment.getCategoryId(), newPayment.getCategoryId());
    }


}
