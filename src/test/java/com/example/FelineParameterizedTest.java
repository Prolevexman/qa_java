package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineParameterizedTest {

    @ParameterizedTest(name = "getKittens(int kittensCount) возвращает kittensCount")
    @ValueSource(ints = {0, 1, Integer.MAX_VALUE})

    void getKittensReturnParam(int expected) {
        Feline feline = new Feline();
        int actual = feline.getKittens(expected);
        assertEquals(expected, actual, () -> String.format("Ожидалось %d, вернулось %d", expected, actual));
    }
}

