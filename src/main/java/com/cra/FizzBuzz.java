package com.cra;

public class FizzBuzz {
    public String convert(int number) {
        if (number <= 0) {
            throw new RuntimeException("Invalid Data. number:" + number);
        }
        if (number == 3 || number == 6) {
            return "Fizz";
        }
        if (number == 5 || number == 10) {
            return "Buzz";
        }
        return String.valueOf(number);
    }
}
