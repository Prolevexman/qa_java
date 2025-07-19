package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    Lion lion;

    @Mock
    Feline feline;

    @BeforeEach
    void setUp() throws Exception{
        lion = new Lion("Самец", feline);
    }

    @Test
    @DisplayName("Проверяет, что метод getFood() возвращает список еды от Feline")
    void getFoodShouldInvokeAndReturnResult() throws Exception{
        List<String> expectedFood = List.of("Животные","Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, lion.getFood(), "getFood() должен возвращать список еды полученный от feline.eatMeat() ");
        Mockito.verify(feline, Mockito.description("Метод eatMeat() не был вызван")).eatMeat();
    }

    @Test
    @DisplayName("Проверяет, что метод getKittens() возвращает результат от Feline")
    void getKittensShouldInvokeAndReturnResult() {
        int expected = 1;
        Mockito.when(feline.getKittens()).thenReturn(expected);
        assertEquals(expected, lion.getKittens(), "getKittens() должен возвращать количество котян от feline.getKittens()");
        Mockito.verify(feline, Mockito.description("Метод getKittens() не был вызван")).getKittens();
    }

    @Test
    @DisplayName("Бросает исключение при недопустимом значении пола")
    void constructorShouldThrowsExceptionWhenSexIsInvalid() {
        Exception exception = assertThrows(Exception.class, () -> {new Lion("Особь 2", feline);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
