package ru.javarush.vladimirn.cryptoanalyzer.printers;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.constants.Strings;
import ru.javarush.vladimirn.cryptoanalyzer.exceptions.AppException;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirectoryPrinter {


    public static void print() {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Path.of(Constants.TXT_FOLDER))) {
            System.out.println(Strings.DIRECTORY_CHOOSE_WISELY);
            for (Path path : directoryStream) {
                if (Files.isRegularFile(path)) {
                    System.out.println(path);
                }
            }
            System.out.println(Strings.WHICH_FILE);
        } catch (IOException e) {
            throw new AppException(Strings.ERROR_DIR_STREAM, e);
        }
    }

}
