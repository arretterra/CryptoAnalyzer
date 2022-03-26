package ru.javarush.vladimirn.cryptoanalyzer.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextValidator {

    public static boolean validate(String input) {
        String wordsVerifier = "[\"'\\-\\s][А-ЯЁ]?[а-яё]*[.,\"':\\-!?\\s]";
        String symbolsVerifier = "(?<=[а-яА-ЯёЁ])[,\"':\\-](?=[\\s])";
        Pattern finder = Pattern.compile("[.,\"':\\-!?\\s][а-яА-ЯёЁ]+[.,\"':\\-!?\\s]");
        Pattern spaceBar = Pattern.compile("[ ]");
        Pattern symbols = Pattern.compile("[,\"':\\-]");
        Matcher spaceMatcher = spaceBar.matcher(input);
        if (!spaceMatcher.find()) {
            return false;
        }
        Matcher symbolsMatcher = symbols.matcher(input);
        while (symbolsMatcher.find()) {
            if (Pattern.matches(symbolsVerifier, symbolsMatcher.group())) {
                return false;
            }
        }
        Matcher matcher = finder.matcher(input);
        int start = 0;
        if (matcher.find()) {
            while (matcher.find(start)) {
                start = matcher.end() - 1;
                if (!Pattern.matches(wordsVerifier, matcher.group())) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

}
