package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AlexLionTest {

    AlexLion alexLion;

    @Mock
    Feline feline;

    @BeforeEach
    void setUp() throws Exception {
        alexLion = new AlexLion(feline);
    }

    @Test
    @DisplayName("AlexLion самец и имеет гриву")
    void testAlexLionAlwaysHasMane() {
        boolean actual = alexLion.doesHaveMane();
        assertTrue(actual, () -> String.format("AlexLion должен иметь гриву, так как он 'Самец'. Ожидалось true, но фактически: %b", actual));
    }

    @Test
    @DisplayName("Метод getFriends возвращает ожидаемый список друзей")
    void getFriendsReturnListOfFriends() {
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        List<String> actual = alexLion.getFriends();
        assertEquals(expected, actual, () -> String.format("Ожидаемый список: %s, полученный %s", expected, actual));
    }
    @Test
    @DisplayName("Метод getPlaceOfLiving возвращает ожидаемое место жительства")
    void getPlaceOfLivingReturnCorrectPlace() {
        String expected = "Нью-Йоркский зоопарк";
        String actual = alexLion.getPlaceOfLiving();
        assertEquals(expected,actual, () -> String.format("Алекс должен жить в %s, а живет в %s", expected, actual));
    }

    @Test
    @DisplayName("AlexLion не имеет детёнышей")
    void getKittensReturnsZero(){
        int actual = alexLion.getKittens();
        assertEquals(0, actual, "Ожидаемый результат 0 детынышей, а вернулось: " + actual);
    }

}
