package ru.javarush.vladimirn.cryptoanalyzer.requesters;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;

import java.util.Scanner;

public class ActionRequester {

    public static String request() {
        System.out.println("Type an action you want to perform.\n" +
                "(encode/decode/bruteforce or press Enter for encode)");
        String action;
        Scanner scanner = Constants.SCANNER;
        while (true) {
            action = scanner.nextLine();
            if (action.equals("") || action.matches("\\s+")) {
                action = "encode";
                break;
            } else if (action.equalsIgnoreCase("encode") || action.equalsIgnoreCase("decode")
                    || action.equalsIgnoreCase("bruteforce")) {
                break;
            } else {
                System.err.println("Can't recognize action, try again.");
            }
        }
        return action;
    }
}
