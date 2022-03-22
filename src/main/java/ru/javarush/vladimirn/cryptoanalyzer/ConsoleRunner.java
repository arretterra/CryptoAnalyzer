package ru.javarush.vladimirn.cryptoanalyzer;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;
import ru.javarush.vladimirn.cryptoanalyzer.entity.ResultCode;
import ru.javarush.vladimirn.cryptoanalyzer.exceptions.AppException;
import ru.javarush.vladimirn.cryptoanalyzer.printers.ExceptionLogPrinter;
import ru.javarush.vladimirn.cryptoanalyzer.printers.WelcomeMessage;

import java.io.IOException;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException {
        WelcomeMessage.print();
        Application application = new Application();
        Result result = new Result("Process failed. See log file in: " + Constants.TXT_FOLDER + "log.txt.",
                ResultCode.ERROR);
        try {
            result = application.run(args);
        } catch (AppException e) {
            ExceptionLogPrinter.printLog(e);
        }
        System.out.println(result);
    }
}
