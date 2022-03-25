package ru.javarush.vladimirn.cryptoanalyzer;

import ru.javarush.vladimirn.cryptoanalyzer.controllers.MainController;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;
import ru.javarush.vladimirn.cryptoanalyzer.entity.ResultCode;
import ru.javarush.vladimirn.cryptoanalyzer.loopers.ConsoleLooper;
import ru.javarush.vladimirn.cryptoanalyzer.loopers.InputFileLooper;
import ru.javarush.vladimirn.cryptoanalyzer.constants.Strings;
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
            System.out.println(Strings.RERUN_MESSAGE);
        } else {
            System.err.println(Strings.NOT_ENOUGH_ARGS);
            System.out.println(Strings.START_THE_PROGRAM);
        }
        consoleMaintain();
        return new Result("Shutting down.", ResultCode.BYEBYE);
    }


    private void consoleMaintain() {
        System.out.println(Strings.TO_QUIT_MESSAGE);
        ConsoleLooper.loop(mainController);
    }
}
