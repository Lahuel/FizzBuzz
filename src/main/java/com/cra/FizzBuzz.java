package com.cra;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    private static final int START_INCLUSIVE = 1;
    private static final int END_EXCLUSIVE = 101;
    private static final int DIVISOR_THREE = 3;
    private static final int DIVISOR_FIVE = 5;
    private static final String FIZZBUZZ = "FizzBuzz";
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    public void fizzbuzz() {
        for (String result : getList()) {
            System.out.println(result);
        }
    }

    public List<String> getList() {
        List<String> result = new ArrayList<>();
        for (int i = START_INCLUSIVE; i < END_EXCLUSIVE; i++) {
            result.add(convert(i));
        }
        return result;
    }

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
