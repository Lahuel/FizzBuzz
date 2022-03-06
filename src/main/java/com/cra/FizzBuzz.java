package com.cra;

import java.util.List;
import java.util.stream.IntStream;

import static com.cra.Constants.*;
import static java.util.stream.Collectors.toList;

public class FizzBuzz {
    private Converter converter;
    private final int startInclusive;
    private final int endExclusive;

    public FizzBuzz(final Converter converter, int startInclusive, int endExclusive) {
        this.converter = converter;
        this.startInclusive = startInclusive;
        this.endExclusive = endExclusive;
    }

    public void fizzbuzz() {
        getList().forEach(System.out::println);
    }

    List<String> getList() {
        return IntStream.range(startInclusive, endExclusive)
                .boxed()
                .collect(toList())
                .stream()
                .map(number -> converter.convert(number))
                .collect(toList());
    }
}
