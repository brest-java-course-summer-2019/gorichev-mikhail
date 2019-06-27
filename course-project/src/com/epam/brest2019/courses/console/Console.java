package com.epam.brest2019.courses.console;

import com.epam.brest2019.courses.value.CorrectValue;
import com.epam.brest2019.courses.value.EnteredValue;
import com.epam.brest2019.courses.value.IncorrectValue;
import com.epam.brest2019.courses.value.ValueWorker;

import java.math.BigDecimal;
import java.util.Scanner;

public class Console {

    private Scanner scanner;

    public Console() {
        this.scanner = new Scanner(System.in);
    }

    public BigDecimal getValue(String message) {
        EnteredValue value = receiveValue(message);
        if (value.getType() != EnteredValue.Types.EXIT) {
            CorrectValue correctValue = (CorrectValue) value;
            System.out.println("Value:" + correctValue.getValue());
            return correctValue.getValue();
        } else {
            System.out.println("Bye!");
            System.exit(0);
            return null;
        }
    }

    private EnteredValue receiveValue(String message) {
        EnteredValue enteredValue = new IncorrectValue();
        while (enteredValue.getType() == EnteredValue.Types.INCORRECT) {
            System.out.println(message);
            enteredValue = ValueWorker.parseInputValue(scanner.nextLine());
        }
        return enteredValue;
    }
}
