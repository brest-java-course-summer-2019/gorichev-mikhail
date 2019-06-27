package com.epam.brest2019.courses.contract;

import java.math.BigDecimal;

public class Price {

    private BigDecimal pricePerKg;
    private BigDecimal pricePerKm;

    public Price(BigDecimal pricePerKg, BigDecimal pricePerKm) {
        this.pricePerKg = pricePerKg;
        this.pricePerKm = pricePerKm;
    }

    public BigDecimal getPricePerKg() {
        return pricePerKg;
    }

    public BigDecimal getPricePerKm() {
        return pricePerKm;
    }

}
