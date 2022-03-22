package ru.javarush.vladimirn.cryptoanalyzer.printers;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.exceptions.AppException;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirectoryPrinter {

    public static void print() {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Path.of(Constants.TXT_FOLDER))) {
            System.out.println("Ok, here is your files in working directory. Choose wisely.");
            for (Path path : directoryStream) {
                if (Files.isRegularFile(path)) {
                    System.out.println(path);
                }
            }
            System.out.println("So which file contains our input text?");
        } catch (IOException e) {
            throw new AppException("Problem while printing directory stream.", e);
        }
    }

}
