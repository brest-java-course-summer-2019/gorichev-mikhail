package com.epam.brest2019.courses.deal;

import com.epam.brest2019.courses.price.Price;

import java.math.BigDecimal;

public class Deal {

    private BigDecimal distance;
    private BigDecimal weight;
    private BigDecimal cost;
    private Price price;

    public Deal(BigDecimal distance, BigDecimal weight, Price price) {
        this.distance = distance;
        this.weight = weight;
        this.price = price;
        this.cost = calculateCost();
        this.price.addDeal(this);
    }

    private BigDecimal calculateCost() {
        return distance.multiply(price.getPricePerKm()).add(weight.multiply(price.getPricePerKg()));
    }

    public BigDecimal getCost() {
        return cost;
    }

}
