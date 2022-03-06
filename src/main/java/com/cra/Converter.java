package com.cra;

import static com.cra.Constants.*;

public class Converter {
    public String convert(int number) {
        if (number <= 0) {
            throw new RuntimeException("Invalid Data. number:" + number);
        }
        if (number % DIVISOR_THREE == 0 && number % DIVISOR_FIVE == 0) {
            return FIZZBUZZ;
        }
        if (number % DIVISOR_THREE == 0) {
            return FIZZ;
        }
        if (number % DIVISOR_FIVE == 0) {
            return BUZZ;
        }
        return String.valueOf(number);
    }
}
