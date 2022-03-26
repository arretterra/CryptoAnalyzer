package ru.javarush.vladimirn.cryptoanalyzer;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Strings;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;
import ru.javarush.vladimirn.cryptoanalyzer.entity.ResultCode;
import ru.javarush.vladimirn.cryptoanalyzer.exceptions.AppException;
import ru.javarush.vladimirn.cryptoanalyzer.printers.ExceptionLogPrinter;

import java.io.IOException;

public class ConsoleRunner {


    public static void main(String[] args) throws IOException {
        System.out.println(Strings.WELCOME_MESSAGE);
        Application application = new Application();
        Result result = new Result(Strings.LOG_MESSAGE, ResultCode.ERROR);
        try {
            result = application.run(args);
        } catch (AppException e) {
            ExceptionLogPrinter.printLog(e);
        }
        System.out.println(result);
    }
}
