package com.epam.brest2019.courses;

import com.epam.brest2019.courses.console.Console;
import com.epam.brest2019.courses.contract.Price;
import com.epam.brest2019.courses.deal.Deal;
import com.epam.brest2019.courses.files.CVSFileReader;
import com.epam.brest2019.courses.files.FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class Main {

    static private final String PRICE_PER_KM_FILE_PATH = "price_per_km.csv";

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new CVSFileReader();
        Map<Integer, BigDecimal> distancePrices = fileReader.readData(PRICE_PER_KM_FILE_PATH);
        if (distancePrices == null || distancePrices.isEmpty()) {
            throw new FileNotFoundException("File with price per km not found");
        }

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
