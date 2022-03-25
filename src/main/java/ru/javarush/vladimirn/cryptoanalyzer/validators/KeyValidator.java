package ru.javarush.vladimirn.cryptoanalyzer.validators;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Strings;
import ru.javarush.vladimirn.cryptoanalyzer.requesters.KeyRequester;

public class KeyValidator {

    public static String exists(String[] parameters) {
        try {
            return parameters[2];
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.err.println(Strings.KEY_NOT_FOUND);
            return KeyRequester.request();
        }
    }
}
