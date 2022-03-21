package ru.javarush.vladimirn.cryptoanalyzer.loopers;

import ru.javarush.vladimirn.cryptoanalyzer.controllers.MainController;
import ru.javarush.vladimirn.cryptoanalyzer.requesters.ArgsRequester;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleLooper {

    public static void loop(Scanner sc, MainController mainController) {
        while (sc.nextLine().equals("")) {
            String[] argsNew = ArgsRequester.run(sc);
            String action = argsNew[0];
            String[] parameters = Arrays.copyOfRange(argsNew, 1, argsNew.length);
            System.out.println(mainController.doAction(action, parameters));
            System.out.println("""
                Press Enter to run the program again.
                Or type anything to quit.""");
        }
    }

}
