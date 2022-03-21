package ru.javarush.vladimirn.cryptoanalyzer;

import ru.javarush.vladimirn.cryptoanalyzer.controllers.MainController;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;
import ru.javarush.vladimirn.cryptoanalyzer.entity.ResultCode;
import ru.javarush.vladimirn.cryptoanalyzer.loopers.ConsoleLooper;
import java.util.Arrays;
import java.util.Scanner;

public class Application {

    private final MainController mainController;

    public Application() {
        mainController = new MainController();
    }

    public Result run(String[] args) {
        if (args.length > 2) {
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            System.out.println(mainController.doAction(action, parameters));
            System.out.println("Press Enter to rerun the program with manual arguments.");
            consoleMaintain();
        } else {
            System.out.println("""
                    Not enough program arguments.
                    Executing console mode.
                    
                    Press Enter to start the program.""");
            consoleMaintain();
        } return new Result("Shutting down.", ResultCode.BYEBYE);
    }

    private void consoleMaintain() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Or type anything to quit.");
            ConsoleLooper.loop(sc, mainController);
        }
    }
}
