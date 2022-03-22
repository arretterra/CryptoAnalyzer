package ru.javarush.vladimirn.cryptoanalyzer.requesters;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.generators.KeyRandomGenerator;

import java.util.Scanner;

public class KeyRequester {

    public static String run() {
        System.out.println("Type an encryption key.\n" +
                "Or press Enter to randomly generate it.");
        String key;
        Scanner scanner = Constants.SCANNER;
        key = scanner.nextLine();
        if (key.equals("") || key.matches("\\s+")) {
            key = Integer.toString(KeyRandomGenerator.generate());
        }
        return key;
    }
}