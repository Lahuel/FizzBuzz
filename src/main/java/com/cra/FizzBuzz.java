package com.cra;

public class FizzBuzz {
    public void fizzbuzz() {

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
