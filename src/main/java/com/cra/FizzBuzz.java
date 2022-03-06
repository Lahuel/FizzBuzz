package com.cra;

import java.util.ArrayList;
import java.util.List;

import static com.cra.Constants.*;

public class FizzBuzz {
    public void fizzbuzz() {
        for (String result : getList()) {
            System.out.println(result);
        }
    }

    List<String> getList() {
        List<String> result = new ArrayList<>();
        for (int i = START_INCLUSIVE; i < END_EXCLUSIVE; i++) {
            result.add(convert(i));
        }
        return result;
    }

    String convert(int number) {
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
