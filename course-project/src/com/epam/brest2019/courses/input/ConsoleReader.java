package com.epam.brest2019.courses.input;

import com.epam.brest2019.courses.value.CorrectValue;
import com.epam.brest2019.courses.value.EnteredValue;
import com.epam.brest2019.courses.value.IncorrectValue;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleReader implements InputReader{

    private Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    public BigDecimal getValue(String message) {
        EnteredValue value = receiveValue(message);
        if (value.getType() != EnteredValue.Types.EXIT) {
            CorrectValue correctValue = (CorrectValue) value;
            System.out.println("Value:" + correctValue.getValue());
            return correctValue.getValue();
        }
        System.out.println("Bye!");
        System.exit(0);
        return null;
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
