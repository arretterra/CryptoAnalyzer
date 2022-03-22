package ru.javarush.vladimirn.cryptoanalyzer.validators;

import ru.javarush.vladimirn.cryptoanalyzer.requesters.KeyRequester;

public class KeyValidator {

    public static String exists(String[] parameters) {
        try {
            return parameters[2];
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.err.println("Key not found.");
            return KeyRequester.run();
        }
    }
}
