package ru.javarush.vladimirn.cryptoanalyzer;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;
import ru.javarush.vladimirn.cryptoanalyzer.entity.ResultCode;
import ru.javarush.vladimirn.cryptoanalyzer.exceptions.AppException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException {
        Application application = new Application();
        Result result = new Result("Process failed. See log file in: " + Constants.TXT_FOLDER, ResultCode.ERROR);
        try {
            result = application.run(args);
        } catch (AppException e) {
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(Constants.TXT_FOLDER + "log.txt"))) {
                bufferedWriter.write("Exception tells us: " + e.getMessage() + "\n");
                bufferedWriter.write("That was in class: " + e.getClass() + "\n");
                bufferedWriter.write("Because we've got: " + e.getCause() + "\n");
                bufferedWriter.write("Here is StackTrace: \n");
                PrintStream ps = new PrintStream(Constants.TXT_FOLDER + "log.txt");
                e.printStackTrace(ps);
                ps.close();
            }
        }
        System.out.println(result);
    }
}
