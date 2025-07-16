package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    private Feline feline;

    @InjectMocks
    private Cat cat;

    @Test
    @DisplayName("Проверяет, что кошка издаёт 'Мяу'")
    void shouldReturnMeowWhenCatMakesSound() {
        String actual = cat.getSound();
        assertEquals("Мяу", actual, "Кошка должна издавать звук 'Мяу'");
    }

    @Test
    @DisplayName("Проверяет, что метод getFood() возвращает список еды от Feline")
    void shouldReturnFoodFromPredator() throws Exception{
        List<String> expectedFood = List.of("Животные","Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, cat.getFood());
    }
    //добавить тест на пустой список

    @Test
    @DisplayName("Проверяет, что метод getFood() пробрасывает Exception")
    void shouldThrowExceptionWhenPredatorThrows() throws Exception {
        Mockito.when(feline.eatMeat()).thenThrow(new Exception("Исключение у feline"));
        Exception exception = assertThrows(Exception.class, () -> cat.getFood());
        assertEquals("Исключение у feline", exception.getMessage());
    }

}
