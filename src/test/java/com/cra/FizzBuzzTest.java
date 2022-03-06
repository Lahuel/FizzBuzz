package com.cra;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FizzBuzzTest {
    @Test
    void fizzbuzzForMultiplesOfThreeAndFiveTest() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("FizzBuzz", fizzBuzz.convert(15));
        assertEquals("FizzBuzz", fizzBuzz.convert(30));
        assertEquals("FizzBuzz", fizzBuzz.convert(45));
    }

    @Test
    void fizzForMultiplesOfThreeTest() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("Fizz", fizzBuzz.convert(3));
        assertEquals("Fizz", fizzBuzz.convert(6));
        assertEquals("Fizz", fizzBuzz.convert(9));
    }

    @Test
    void buzzForMultiplesFiveTest() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("Buzz", fizzBuzz.convert(5));
        assertEquals("Buzz", fizzBuzz.convert(10));
        assertEquals("Buzz", fizzBuzz.convert(20));
    }

    @Test
    void printTheNumberForOthersTest() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("1", fizzBuzz.convert(1));
        assertEquals("2", fizzBuzz.convert(2));
        assertEquals("7", fizzBuzz.convert(7));
        assertEquals("11", fizzBuzz.convert(11));
        assertEquals("13", fizzBuzz.convert(13));
    }

    @Test
    void throwsInvalidDataExceptionTest() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertThrows(RuntimeException.class,
                ()->fizzBuzz.convert(0)
        );
        assertThrows(RuntimeException.class,
                ()->fizzBuzz.convert(-1)
        );
        assertThrows(RuntimeException.class,
                ()->fizzBuzz.convert(-3)
        );
        assertThrows(RuntimeException.class,
                ()->fizzBuzz.convert(-5)
        );
        assertThrows(RuntimeException.class,
                ()->fizzBuzz.convert(-15)
        );
    }
}
