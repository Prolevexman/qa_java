package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FelineTest {

    private static final String FAMILY = "Кошачьи";
    Feline feline;

    @BeforeEach
    void setUp() {
        feline = new Feline();
    }

    @Test
    @DisplayName("Проверка, что Feline относится к семейству " + FAMILY)
    void shouldReturnFamilyName() {
        String actual = feline.getFamily();
        assertEquals(FAMILY, actual, "Feline должен относится к семейству " + FAMILY);
    }

    @Test
    @DisplayName("По умолчанию возвращается 1 детеныш")
    void shouldReturnOneYoungByDefault() {
        assertEquals(1, feline.getKittens(), "По умолчанию должен быть 1 детеныш");
    }

    @Test
    @DisplayName("eatMeat() возвращает список еды для хищников в классе Feline")
    void shouldReturnCarnivoreFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood, "Хищники должны питаться мясом");
    }

    @Test
    @DisplayName("Проверяет, что метод eatMeat() пробрасывает Exception")
    void shouldThrowExceptionWhenGetFoodThrows() throws Exception {
        Feline feline = new FelineException();
        Exception exception = assertThrows(Exception.class, feline::eatMeat);
        assertEquals("Исключение в getFood()", exception.getMessage());
    }
    private static class FelineException extends Feline {
        @Override
        public List<String> getFood(String animalKind) throws Exception {
            throw new Exception("Исключение в getFood()");
        }
    }
}
