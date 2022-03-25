package ru.javarush.vladimirn.cryptoanalyzer.requesters;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.constants.Strings;

public class ActionRequester {

    public static String request() {
        System.out.println(Strings.ACTION_REQUEST);
        String action;
        while (true) {
            action = Constants.SCANNER.nextLine();
            if ("".equals(action) || action.matches("\\s+")) {
                action = "encode";
                break;
            } else if ("encode".equalsIgnoreCase(action) || "decode".equalsIgnoreCase(action)
                    || "bruteforce".equalsIgnoreCase(action)) {
                break;
            } else {
                System.err.println(Strings.CANT_RECOGNIZE_ACTION);
            }
        }
        return action;
    }
}
