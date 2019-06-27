package com.epam.brest2019.courses.deal;

import com.epam.brest2019.courses.contract.Price;

import java.math.BigDecimal;
import java.util.Date;

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
    }

    private BigDecimal calculateCost() {
        return distance.multiply(price.getPricePerKm()).add(weight.multiply(price.getPricePerKg()));
    }

    public BigDecimal getCost() {
        return cost;
    }

}
