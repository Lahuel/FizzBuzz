package com.cra;

import java.util.List;

public class Converter {
    private List<Divisor> divisors;

    public Converter(final List<Divisor> divisors) {
        this.divisors = divisors;
    }

    public String convert(int number) {
        if (number <= 0) {
            throw new RuntimeException("Invalid Data. number:" + number);
        }

        StringBuilder sb = new StringBuilder();
        for (Divisor divisor : divisors) {
            if (isMultiple(number, divisor.getDivisor())) {
                sb.append(divisor.getSound());
            }
        }
        return getResult(number, sb.toString());
    }

    private boolean isMultiple(int number, int divisor) {
        if (divisor == 0) {
            throw new RuntimeException("Divided by Zero. divisor:" + divisor);
        }
        return number % divisor == 0;
    }

    private String getResult(int number, String result) {
        if (result == null || result.isEmpty()) {
            return String.valueOf(number);
        }
        return result;
    }
}
