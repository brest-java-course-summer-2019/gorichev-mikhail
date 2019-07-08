package com.epam.brest2019.courses;

import com.epam.brest2019.courses.files.CSVFileReader;
import com.epam.brest2019.courses.input.ConsoleReader;
import com.epam.brest2019.courses.price.Price;
import com.epam.brest2019.courses.deal.Deal;
import com.epam.brest2019.courses.files.FileReader;
import com.epam.brest2019.courses.input.InputReader;
import com.epam.brest2019.courses.selector.SelectorFromMap;
import com.epam.brest2019.courses.selector.ValueSelector;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class Main {

    static private final String PRICE_PER_KM_FILE_PATH = "price_per_km.csv";
    static private final String PRICE_PER_KG_FILE_PATH = "price_per_kg.csv";

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new CSVFileReader();
        Map<Integer, BigDecimal> distancePrices = fileReader.readData(PRICE_PER_KM_FILE_PATH);
        if (distancePrices == null || distancePrices.isEmpty()) {
            throw new FileNotFoundException("File with price per km not found");
        }

        Map<Integer, BigDecimal> weightPrices = fileReader.readData(PRICE_PER_KG_FILE_PATH);
        if (weightPrices == null || distancePrices.isEmpty()) {
            throw new FileNotFoundException("File with price per kg not found");
        }

        InputReader inputReader = new ConsoleReader();

        BigDecimal distance = inputReader.getValue("Enter distance in km or q for quit");
        BigDecimal weight = inputReader.getValue("Enter weight in kg or q for quit");

        ValueSelector selector = new SelectorFromMap();

        BigDecimal pricePerKm = selector.selectValue(distancePrices, distance);
        BigDecimal pricePerKg = selector.selectValue(weightPrices, weight);

        Price standardPrice = new Price(pricePerKg, pricePerKm);

        Deal firstDeal = new Deal(distance, weight, standardPrice);

        System.out.println("Deal cost: " + firstDeal.getCost());
    }



}
