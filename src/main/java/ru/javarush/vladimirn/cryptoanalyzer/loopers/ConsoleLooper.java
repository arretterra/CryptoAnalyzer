package ru.javarush.vladimirn.cryptoanalyzer.loopers;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.controllers.MainController;
import ru.javarush.vladimirn.cryptoanalyzer.requesters.ArgsRequester;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleLooper {

    public static void loop(MainController mainController) {
        Scanner scanner = Constants.SCANNER;
        while (scanner.nextLine().equals("")) {
            String[] args = ArgsRequester.request();
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            System.out.println(mainController.doAction(action, parameters));
            System.out.println("""
                    Press Enter to run the program again.
                    Or type anything to quit.""");
        }
    }
}
