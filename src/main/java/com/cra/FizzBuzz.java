package com.cra;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public void fizzbuzz() {
        for (String result : getList()) {
            System.out.println(result);
        }
    }

    public List<String> getList() {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            result.add(convert(i));
        }
        return result;
    }

    public String convert(int number) {
        if (number <= 0) {
            throw new RuntimeException("Invalid Data. number:" + number);
        }
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        }
        if (number % 3 == 0) {
            return "Fizz";
        }
        if (number % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(number);
    }
}
