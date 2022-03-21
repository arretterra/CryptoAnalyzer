package ru.javarush.vladimirn.cryptoanalyzer.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextValidator {

    public static boolean run(String input) {
        String verifier = "[.,\"':\\-!?\\s][А-ЯЁ]?[а-яё]*[.,\"':\\-!?\\s]";
        Pattern finder = Pattern.compile("[.,\"':\\-!?\\s][а-яА-ЯёЁ]+[.,\"':\\-!?\\s]");
        Matcher matcher = finder.matcher(input);
        int start = 0;
        while (matcher.find(start)) {
            start = matcher.end() - 1;
            if (!Pattern.matches(verifier, matcher.group())) {
                return false;
            }
        }
        return true;
    }

}
