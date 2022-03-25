package ru.javarush.vladimirn.cryptoanalyzer.validators;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Strings;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileValidator {

    public static boolean notExists(Path path) {
        boolean exists = Files.exists(path);
        if (!exists) {
            System.err.println(Strings.FILE_NOT_FOUND);
            System.out.println(Strings.DIR_PROMT);
        }
        return !exists;
    }

    public static String validateExtension(String fileName) {
        if (!fileName.endsWith(".txt")) {
            fileName = fileName + ".txt";
        }
        return fileName;
    }
}
