package ru.javarush.vladimirn.cryptoanalyzer.generators;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Strings;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Key;

public class MessageGenerator {

    public static String failMessage(String actionName, Key key) {
        return actionName + Strings.ACTION_FAILED + key.getValue() + ".";
    }

    public static String successMessage(String actionName, Key key) {
        return actionName + Strings.RESULT_SUCCESS + key.getValue() + ".";
    }
}
