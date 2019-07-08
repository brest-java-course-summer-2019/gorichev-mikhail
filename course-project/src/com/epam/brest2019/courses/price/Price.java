package com.epam.brest2019.courses.price;

import com.epam.brest2019.courses.deal.Deal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Price {

    private BigDecimal pricePerKg;
    private BigDecimal pricePerKm;
    private List<Deal> dealsList = new ArrayList<>();

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

    public void addDeal(Deal deal) {
        this.dealsList.add(deal);
    }
}
