package ru.javarush.vladimirn.cryptoanalyzer;

import ru.javarush.vladimirn.cryptoanalyzer.controllers.MainController;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;
import ru.javarush.vladimirn.cryptoanalyzer.entity.ResultCode;
import ru.javarush.vladimirn.cryptoanalyzer.requesters.ArgsRequester;

import java.util.Arrays;
import java.util.Scanner;

public class Application {

    private final MainController mainController;

    public Application() {
        mainController = new MainController();
    }

    public Result run(String[] args) {
        if (args.length > 0) {
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            return mainController.doAction(action, parameters);
        } else {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("No program arguments detected.");
                String[] argsNew = ArgsRequester.run(sc);
                String action = argsNew[0];
                String[] parameters = Arrays.copyOfRange(argsNew, 1, argsNew.length);
                return mainController.doAction(action, parameters);
            }
        }

        //TODO other scenarios
        //return new Result("null", ResultCode.ERROR);
    }
}
