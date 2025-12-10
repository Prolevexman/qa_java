package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class FelineTest {

    private static final String FAMILY = "Кошачьи";

    @Spy
    private Feline feline;

    @Test
    @DisplayName("Проверка, что Feline относится к семейству " + FAMILY)
    void shouldReturnFamilyName() {
        String actual = feline.getFamily();
        assertEquals(FAMILY, actual, "Feline должен относится к семейству " + FAMILY);
    }

    @Test
    @DisplayName("Метод getKittens() без параметров вызывает getKittens c параметром 1")
    void getKittensNoParamShouldInvokeGetKittensWith1(){
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    @DisplayName("eatMeat() вызывает getFood() с параметром 'Хищник' и возвращает результат")
    void eatMeatShouldInvokeGetFoodWithParamCarnivoreAndReturnResult() throws Exception {
        List<String> expectedFood = List.of("Животные","Птицы", "Рыба");
        Mockito.doReturn(expectedFood).when(feline).getFood("Хищник");
        List<String> actual = feline.eatMeat();
        assertEquals(expectedFood, actual, () -> String.format("getFood() должен возвращать список еды для хищников, ожидалось %s, вернулось %s", expectedFood, actual));
        Mockito.verify(feline, Mockito.description("Метод getFood() c параметром 'хищник' не был вызван ")).getFood("Хищник");
    }

    @Test
    @DisplayName("Проверяет, что метод eatMeat() пробрасывает Exception")
    void shouldThrowExceptionWhenGetFoodThrows() {
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
