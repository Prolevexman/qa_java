package com.example;

import java.util.ArrayList;
import java.util.List;

public class AlexLion extends Lion{

    private static List<String> alexFriends = new ArrayList<>(List.of("Марти", "Глория", "Мелман"));
    private static String alexHome = "Нью-Йоркский зоопарк";

    public AlexLion(Feline feline) throws Exception {
        super("Самец", feline);
    }

    public List<String> getFriends() {
        return alexFriends;
    }

    public String getPlaceOfLiving() {
        return alexHome;
    }

    @Override
    public int getKittens() {
        return 0;
    }
}
