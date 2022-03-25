package ru.javarush.vladimirn.cryptoanalyzer.requesters;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.generators.KeyRandomGenerator;
import ru.javarush.vladimirn.cryptoanalyzer.constants.Strings;

import java.util.Scanner;

public class KeyRequester {

    public static String request() {
        System.out.println(Strings.KEY_REQUEST);
        String key;
        Scanner scanner = Constants.SCANNER;
        key = scanner.nextLine();
        if ("".equals(key) || key.matches("\\s+")) {
            key = Integer.toString(KeyRandomGenerator.generate());
        }
        return key;
    }
}