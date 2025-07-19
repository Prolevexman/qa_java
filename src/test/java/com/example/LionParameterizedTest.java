package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LionParameterizedTest {

    @Mock
    Feline feline;

    @ParameterizedTest(name = "Пол: {0}, ожидается hasMane = {1}")
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void testDoesHaveMane(String sex, boolean expected) throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expected, lion.doesHaveMane(), () -> "Неверное значение гривы для пола: " + sex);
    }
}
