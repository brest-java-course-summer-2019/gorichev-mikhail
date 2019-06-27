package com.epam.brest2019.courses.value;

public interface EnteredValue {

    enum Types {EXIT, INCORRECT, VALUE}
    Types getType();
}
