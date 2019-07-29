package com.training.payments.sevice;

import com.training.payments.model.Payment;
import com.training.payments.service.PaymentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath:test-service.xml"})
public class PaymentServiceImplTest {

    @Autowired
    private PaymentService paymentService;

    private static final String COFFEE = "Coffee";
    private static final String CINEMA = "Cinema";
    private static final String ADDED_NAME = "Added payment";
    private static final String ADDED_DESCRIPTION = "Added description";
    private static final BigDecimal ADDED_COST = new BigDecimal("233.34");
    private static final String UPDATE_NAME = "Update name";
    private static final String UPDATE_DESCRIPTION = "Update description";

    @Test
    void findAll() {
        List<Payment> payments = paymentService.findAll();
        assertNotNull(payments);
        assertFalse(payments.isEmpty());
    }

    @Test
    void findByCategoryId() {
        List<Payment> payments = paymentService.findByCategoryId(1);
        assertNotNull(payments);
        assertEquals(payments.size(), 2);
    }

    @Test
    void findById() {
        Payment payment = paymentService.findById(2);

        assertNotNull(payment);
        assertEquals(COFFEE, payment.getPaymentName());
    }

    @Test
    void findByName() {
        Payment payment = paymentService.findByName(CINEMA);

        assertNotNull(payment);
        assertEquals(payment.getPaymentId().intValue(), 1);
    }

    @Test
    void add() {
        int sizeBeforeAdding = paymentService.findAll().size();
        Payment payment = new Payment(ADDED_NAME, ADDED_DESCRIPTION, ADDED_COST, 4);
        paymentService.add(payment);

        assertTrue(paymentService.findAll().size() > sizeBeforeAdding);
        assertNotNull(paymentService.findByName(ADDED_NAME));
    }

    @Test
    void update() {
        Payment payment = new Payment(ADDED_NAME, ADDED_DESCRIPTION, ADDED_COST, 4);
        paymentService.add(payment);
        int id = payment.getPaymentId();
        payment.setPaymentName(UPDATE_NAME);
        payment.setPaymentDescription(UPDATE_DESCRIPTION);
        paymentService.update(payment);
        payment = paymentService.findById(id);

        assertNotNull(payment);
        assertEquals(payment.getPaymentName(), UPDATE_NAME);
        assertEquals(payment.getPaymentDescription(), UPDATE_DESCRIPTION);
    }

    @Test
    void remove() {
        Payment payment = new Payment(ADDED_NAME, ADDED_DESCRIPTION, ADDED_COST, 4);
        paymentService.add(payment);
        int sizeBeforeDeleting = paymentService.findAll().size();
        paymentService.delete(payment.getPaymentId());

        Assertions.assertThrows(RuntimeException.class, () -> paymentService.findByName(ADDED_NAME));
        assertTrue(sizeBeforeDeleting > paymentService.findAll().size());
    }
}
