package com.cra;

import static com.cra.Constants.*;

public class Converter {
    public String convert(int number) {
        if (number <= 0) {
            throw new RuntimeException("Invalid Data. number:" + number);
        }
        if (isMultiple(number, DIVISOR_THREE) && isMultiple(number, DIVISOR_FIVE)) {
            return FIZZBUZZ;
        }
        if (isMultiple(number, DIVISOR_THREE)) {
            return FIZZ;
        }
        if (isMultiple(number, DIVISOR_FIVE)) {
            return BUZZ;
        }
        return String.valueOf(number);
    }

    private boolean isMultiple(int number, int divisor) {
        if (divisor == 0) {
            throw new RuntimeException("Divided by Zero. divisor:" + divisor);
        }
        return number % divisor == 0;
    }
}
