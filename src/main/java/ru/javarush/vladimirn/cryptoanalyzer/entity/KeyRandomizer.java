package ru.javarush.vladimirn.cryptoanalyzer.entity;

import java.util.Random;

public class KeyRandomizer {

    public static int generate() {
        Random random = new Random();
        return 1 + random.nextInt(85);
    }
}
