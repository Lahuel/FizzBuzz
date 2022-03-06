package com.cra;

import java.util.List;
import java.util.stream.IntStream;

import static com.cra.Constants.*;
import static java.util.stream.Collectors.toList;

public class FizzBuzz {
    public void fizzbuzz() {
        getList().forEach(System.out::println);
    }

    List<String> getList() {
        return IntStream.range(START_INCLUSIVE, END_EXCLUSIVE)
                .boxed()
                .collect(toList())
                .stream()
                .map(number -> new Converter().convert(number))
                .collect(toList());
    }
}
