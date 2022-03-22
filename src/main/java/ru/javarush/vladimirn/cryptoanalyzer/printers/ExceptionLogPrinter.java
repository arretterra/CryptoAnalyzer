package ru.javarush.vladimirn.cryptoanalyzer.printers;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.exceptions.AppException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExceptionLogPrinter {

    public static void printLog(AppException e) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(Constants.TXT_FOLDER
                + "log.txt"))) {
            bufferedWriter.write("Exception tells us: " + e.getMessage());
            bufferedWriter.newLine();
            bufferedWriter.write("That was in class: " + e.getClass());
            bufferedWriter.newLine();
            bufferedWriter.write("Because we've got: " + e.getCause());
            bufferedWriter.newLine();
            bufferedWriter.write("Here is StackTrace:");
            bufferedWriter.newLine();
            PrintStream ps = new PrintStream(Constants.TXT_FOLDER + "log.txt");
            e.printStackTrace(ps);
            ps.close();
        }
    }
}
