package ru.javarush.vladimirn.cryptoanalyzer.requesters;

import java.util.Scanner;

public class ActionRequester {

    protected static String run(Scanner sc) {
        String action;
        while(true) {
            action = sc.nextLine();
            if (action.equals("") || action.matches("\\s+")) {
                action = "encode";
                break;
            } else if (action.equalsIgnoreCase("encode") || action.equalsIgnoreCase("decode")
                    || action.equalsIgnoreCase("bruteforce")) {
                break;
            } else {
                System.out.println("Can't recognize action, try again.");
            }
        }
        return action;
    }
}
