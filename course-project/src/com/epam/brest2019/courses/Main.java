package com.epam.brest2019.courses;

import com.epam.brest2019.courses.console.Console;
import com.epam.brest2019.courses.contract.Price;
import com.epam.brest2019.courses.deal.Deal;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Console console = new Console();

        BigDecimal distance = console.getValue("Enter distance in km or q for quit");
        BigDecimal weight = console.getValue("Enter weight in kg or q for quit");
        BigDecimal pricePerKm = console.getValue("Enter price per km or q for quit");
        BigDecimal pricePerKg = console.getValue("Enter price per kg or q for quit");

        Price standardPrice = new Price(pricePerKg, pricePerKm);
        Deal firstDeal = new Deal(distance, weight, standardPrice);

        System.out.println("Deal cost: " + firstDeal.getCost());
    }

}
