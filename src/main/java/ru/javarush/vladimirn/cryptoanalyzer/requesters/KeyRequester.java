package ru.javarush.vladimirn.cryptoanalyzer.requesters;

import ru.javarush.vladimirn.cryptoanalyzer.entity.KeyRandomizer;

import java.util.Scanner;

public class KeyRequester {

    protected static String run(Scanner sc) {
        String key;
        key = sc.nextLine();
        if (key.equals("") || key.equals(" ")) {
            key = Integer.toString(KeyRandomizer.generate());
        }
        return key;
    }
}