package ru.javarush.vladimirn.cryptoanalyzer;

import ru.javarush.vladimirn.cryptoanalyzer.controllers.MainController;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;
import ru.javarush.vladimirn.cryptoanalyzer.entity.ResultCode;
import ru.javarush.vladimirn.cryptoanalyzer.loopers.ConsoleLooper;
import ru.javarush.vladimirn.cryptoanalyzer.loopers.InputFileLooper;
import ru.javarush.vladimirn.cryptoanalyzer.validators.FileValidator;

import java.util.Arrays;

public class Application {

    private final MainController mainController;

    public Application() {
        mainController = new MainController();
    }

    public Result run(String[] args) {
        if (args.length > 2) {
            String action = args[0];
            args[1] = InputFileLooper.check(FileValidator.validateExtension(args[1]));
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            System.out.println(mainController.doAction(action, parameters));
            System.out.println("Press Enter to rerun the program with manual arguments.");
        } else {
            System.err.println("""
                    Not enough program arguments.
                    Executing console mode.""");
            System.out.println("\nPress Enter to start the program.");
        } consoleMaintain();
        return new Result("Shutting down.", ResultCode.BYEBYE);
    }

    private void consoleMaintain() {
        System.out.println("Or type anything to quit.");
        ConsoleLooper.loop(mainController);

    }
}
