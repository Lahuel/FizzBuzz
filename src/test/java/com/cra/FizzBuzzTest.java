package com.cra;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static com.cra.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(OrderAnnotation.class)
public class FizzBuzzTest {
    private Converter fizzbuzzConverter = new Converter(Arrays.asList(
            new Divisor(DIVISOR_THREE, SOUND_FIZZ),
            new Divisor(DIVISOR_FIVE, SOUND_BUZZ)));

    private Converter fizzbuzzbazzConverter = new Converter(Arrays.asList(
            new Divisor(DIVISOR_THREE, SOUND_FIZZ),
            new Divisor(DIVISOR_FIVE, SOUND_BUZZ),
            new Divisor(DIVISOR_SEVEN, SOUND_BAZZ)));

    private FizzBuzz fizzBuzz = new FizzBuzz(fizzbuzzConverter, START_INCLUSIVE, END_EXCLUSIVE);
    private FizzBuzz fizzBuzzBazz = new FizzBuzz(fizzbuzzbazzConverter, START_INCLUSIVE, END_EXCLUSIVE);

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

    private static final List<String> FIZZBUZZBAZZES_1_100 = Arrays.asList(
            "1", "2", "Fizz", "4", "Buzz", "Fizz", "Bazz", "8", "Fizz", "Buzz",
            "11", "Fizz", "13", "Bazz", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz",
            "FizzBazz", "22", "23", "Fizz", "Buzz", "26", "Fizz", "Bazz", "29", "FizzBuzz",
            "31", "32", "Fizz", "34", "BuzzBazz", "Fizz", "37", "38", "Fizz", "Buzz",
            "41", "FizzBazz", "43", "44", "FizzBuzz", "46", "47", "Fizz", "Bazz", "Buzz",
            "Fizz", "52", "53", "Fizz", "Buzz", "Bazz", "Fizz", "58", "59", "FizzBuzz",
            "61", "62", "FizzBazz", "64", "Buzz", "Fizz", "67", "68", "Fizz", "BuzzBazz",
            "71", "Fizz", "73", "74", "FizzBuzz", "76", "Bazz", "Fizz", "79", "Buzz",
            "Fizz", "82", "83", "FizzBazz", "Buzz", "86", "Fizz", "88", "89", "FizzBuzz",
            "Bazz", "92", "Fizz", "94", "Buzz", "Fizz", "97", "Bazz", "Fizz", "Buzz");

    @Test
    @Order(1)
    @DisplayName("1. FizzBuzz 테스트 with 출력값 비교")
    void fizzbuzzPrintTest() throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        fizzBuzz.fizzbuzz();
        bo.flush();
        String actual = new String(bo.toByteArray());
        assertEquals(getSystemOutString(FIZZBUZZES_1_100), actual);
    }

    @Test
    @Order(2)
    @DisplayName("2. FizzBuzz 테스트 with List<String> 비교")
    void fizzbuzzListTest() {
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

    @ParameterizedTest
    @Order(3)
    @DisplayName("3. 임의의 값에 대한 FizzBuzz 변환 테스트")
    @CsvSource({
            "1,1",
            "2,2",
            "3,Fizz",
            "4,4",
            "5,Buzz",
            "6,Fizz",
            "7,7",
            "8,8",
            "9,Fizz",
            "10,Buzz",
            "11,11",
            "13,13",
            "15,FizzBuzz",
            "17,17",
            "20,Buzz",
            "30,FizzBuzz",
            "45,FizzBuzz"
    })
    void fizzbuzzTest(int number, String expected) {
        assertEquals(expected, fizzbuzzConverter.convert(number));
    }

    @Test
    @Order(4)
    @DisplayName("4. FizzBuzzBazz 테스트 with 출력값 비교")
    void fizzbuzzbazzPrintTest() throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        fizzBuzzBazz.fizzbuzz();
        bo.flush();
        String actual = new String(bo.toByteArray());
        assertEquals(getSystemOutString(FIZZBUZZBAZZES_1_100), actual);
    }

    @Test
    @Order(5)
    @DisplayName("5. FizzBuzzBazz 테스트 with List<String> 비교")
    void fizzbuzzbazzListTest() {
        List<String> actual = fizzBuzzBazz.getList();
        assertEquals(FIZZBUZZBAZZES_1_100, actual);
    }

    @ParameterizedTest
    @Order(6)
    @DisplayName("6. 임의의 값에 대한 FizzBuzzBazz 변환 테스트")
    @CsvSource({
            "1,1",
            "2,2",
            "3,Fizz",
            "4,4",
            "5,Buzz",
            "6,Fizz",
            "7,Bazz",
            "8,8",
            "9,Fizz",
            "10,Buzz",
            "11,11",
            "13,13",
            "14,Bazz",
            "15,FizzBuzz",
            "17,17",
            "20,Buzz",
            "21,FizzBazz",
            "30,FizzBuzz",
            "35,BuzzBazz",
            "45,FizzBuzz",
            "105,FizzBuzzBazz"
    })
    void fizzbuzzbazzTest(int number, String expected) {
        assertEquals(expected, fizzbuzzbazzConverter.convert(number));
    }

    @Test
    @Order(7)
    @DisplayName("7. 0이하의 입력값에 대해서는 Exception")
    void throwsInvalidDataExceptionTest() {
        assertThrows(RuntimeException.class,
                ()->fizzbuzzbazzConverter.convert(0)
        );
        assertThrows(RuntimeException.class,
                ()->fizzbuzzbazzConverter.convert(-1)
        );
        assertThrows(RuntimeException.class,
                ()->fizzbuzzbazzConverter.convert(-3)
        );
        assertThrows(RuntimeException.class,
                ()->fizzbuzzbazzConverter.convert(-5)
        );
        assertThrows(RuntimeException.class,
                ()->fizzbuzzbazzConverter.convert(-7)
        );
        assertThrows(RuntimeException.class,
                ()->fizzbuzzbazzConverter.convert(-15)
        );
    }
}
