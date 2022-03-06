package com.cra;

import java.util.ArrayList;
import java.util.List;

import static com.cra.Constants.*;

public class FizzBuzz {
    public void fizzbuzz() {
        getList().forEach(System.out::println);
    }

    List<String> getList() {
        Converter converter = new Converter();
        List<String> result = new ArrayList<>();
        for (int i = START_INCLUSIVE; i < END_EXCLUSIVE; i++) {
            result.add(converter.convert(i));
        }
        return result;
    }
}
