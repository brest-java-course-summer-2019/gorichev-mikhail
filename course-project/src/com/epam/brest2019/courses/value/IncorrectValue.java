package com.epam.brest2019.courses.value;

public class IncorrectValue implements EnteredValue{

    @Override
    public Types getType() {
        return Types.INCORRECT;
    }
}
