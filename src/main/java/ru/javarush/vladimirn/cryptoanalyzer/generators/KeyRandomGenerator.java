package ru.javarush.vladimirn.cryptoanalyzer.generators;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;

import java.util.Random;

public class KeyRandomGenerator {

    public static int generate() {
        Random random = new Random();
        return 1 + random.nextInt(Constants.getAlphabetLength());
    }
}
