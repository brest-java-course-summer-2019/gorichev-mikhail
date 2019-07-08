package com.epam.brest2019.courses.input;

import com.epam.brest2019.courses.value.CorrectValue;
import com.epam.brest2019.courses.value.EnteredValue;
import com.epam.brest2019.courses.value.ExitValue;
import com.epam.brest2019.courses.value.IncorrectValue;

import java.math.BigDecimal;

public class ValueWorker {

    static private final String QUIT_SYMBOL = "q";

    static public EnteredValue parseInputValue(String inputValue) {
        EnteredValue result = new ExitValue();
        if (!inputValue.trim().toLowerCase().equals(QUIT_SYMBOL)) {
            try {
                BigDecimal value = new BigDecimal(inputValue);
                if (value.compareTo(BigDecimal.ZERO) > 0) {
                    result = new CorrectValue(new BigDecimal(inputValue));
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.format("Incorrect value: %s%n", inputValue);
                result = new IncorrectValue();
            }
        }
        return result;
    }
}
