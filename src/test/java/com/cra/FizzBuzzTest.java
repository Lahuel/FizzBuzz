package com.cra;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FizzBuzzTest {
    private static final List<String> FIZZBUZZES_1_100 = Arrays.asList(
            "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
            "11", "Fizz", "13", "14", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz",
            "Fizz", "22", "23", "Fizz", "Buzz", "26", "Fizz", "28", "29", "FizzBuzz",
            "31", "32", "Fizz", "34", "Buzz", "Fizz", "37", "38", "Fizz", "Buzz",
            "41", "Fizz", "43", "44", "FizzBuzz", "46", "47", "Fizz", "49", "Buzz",
            "Fizz", "52", "53", "Fizz", "Buzz", "56", "Fizz", "58", "59", "FizzBuzz",
            "61", "62", "Fizz", "64", "Buzz", "Fizz", "67", "68", "Fizz", "Buzz",
            "71", "Fizz", "73", "74", "FizzBuzz", "76", "77", "Fizz", "79", "Buzz",
            "Fizz", "82", "83", "Fizz", "Buzz", "86", "Fizz", "88", "89", "FizzBuzz",
            "91", "92", "Fizz", "94", "Buzz", "Fizz", "97", "98", "Fizz", "Buzz");

    @Test
    void fizzbuzzPrintTest() throws IOException {
        FizzBuzz fizzBuzz = new FizzBuzz();
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        fizzBuzz.fizzbuzz();
        bo.flush();
        String actual = new String(bo.toByteArray());
        assertEquals(getSystemOutString(FIZZBUZZES_1_100), actual);
    }

    @Test
    void fizzbuzzListTest() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> actual = fizzBuzz.getList();
        assertEquals(FIZZBUZZES_1_100, actual);
    }

    private String getSystemOutString(List<String> list) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        list.forEach(System.out::println);
        bo.flush();
        return new String(bo.toByteArray());
    }

    @Test
    void fizzbuzzForMultiplesOfThreeAndFiveTest() {
        Converter converter = new Converter();
        assertEquals("FizzBuzz", converter.convert(15));
        assertEquals("FizzBuzz", converter.convert(30));
        assertEquals("FizzBuzz", converter.convert(45));
    }

    @Test
    void fizzForMultiplesOfThreeTest() {
        Converter converter = new Converter();
        assertEquals("Fizz", converter.convert(3));
        assertEquals("Fizz", converter.convert(6));
        assertEquals("Fizz", converter.convert(9));
    }

    @Test
    void buzzForMultiplesFiveTest() {
        Converter converter = new Converter();
        assertEquals("Buzz", converter.convert(5));
        assertEquals("Buzz", converter.convert(10));
        assertEquals("Buzz", converter.convert(20));
    }

    @Test
    void printTheNumberForOthersTest() {
        Converter converter = new Converter();
        assertEquals("1", converter.convert(1));
        assertEquals("2", converter.convert(2));
        assertEquals("7", converter.convert(7));
        assertEquals("11", converter.convert(11));
        assertEquals("13", converter.convert(13));
    }

    @Test
    void throwsInvalidDataExceptionTest() {
        Converter converter = new Converter();
        assertThrows(RuntimeException.class,
                ()->converter.convert(0)
        );
        assertThrows(RuntimeException.class,
                ()->converter.convert(-1)
        );
        assertThrows(RuntimeException.class,
                ()->converter.convert(-3)
        );
        assertThrows(RuntimeException.class,
                ()->converter.convert(-5)
        );
        assertThrows(RuntimeException.class,
                ()->converter.convert(-15)
        );
    }
}
