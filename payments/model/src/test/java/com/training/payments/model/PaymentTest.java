package com.training.payments.model;

import com.training.payments.model.Payment;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PaymentTest {

    private Payment payment = new Payment();

    @Test
    public void getPaymentId() {
        payment.setPaymentId(2);
        Assert.assertEquals(payment.getPaymentId().intValue(), 2);
    }

    @Test
    public void getCategoryId() {
        payment.setCategoryId(4);
        Assert.assertEquals(payment.getCategoryId().intValue(), 4);
    }

    @Test
    public void getPaymentName() {
        payment.setPaymentName("Payment Name");
        Assert.assertEquals(payment.getPaymentName(), "Payment Name");
    }

    @Test
    public void getPaymentDescription() {
        payment.setPaymentDescription("Payment description");
        Assert.assertEquals(payment.getPaymentDescription(), "Payment description");
    }

    @Test
    public void getPaymentCost() {
        payment.setPaymentCost(new BigDecimal("400.2"));
        Assert.assertEquals(payment.getPaymentCost(), new BigDecimal("400.2"));
    }
}