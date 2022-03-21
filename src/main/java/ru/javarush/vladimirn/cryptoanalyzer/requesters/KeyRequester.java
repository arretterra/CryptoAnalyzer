package ru.javarush.vladimirn.cryptoanalyzer.requesters;

import ru.javarush.vladimirn.cryptoanalyzer.generators.KeyRandomGenerator;
import java.util.Scanner;

public class KeyRequester {

    protected static String run(Scanner sc) {
        String key;
        key = sc.nextLine();
        if (key.equals("") || key.matches("\\s+")) {
            key = Integer.toString(KeyRandomGenerator.generate());
        }
        return key;
    }
}