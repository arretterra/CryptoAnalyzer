package ru.javarush.vladimirn.cryptoanalyzer.validators;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileValidator {

    public static boolean exists(Path path) {
        boolean success = Files.exists(path);
        if (!success) {
            System.err.println("File not found. Try another one.");
            System.out.println("You can type \"dir\" to peek into the working directory.");
        }
        return success;
    }

    public static String extensionValidate(String fileName) {
        if (!fileName.endsWith(".txt")) {
            fileName = fileName + ".txt";
        }
        return fileName;
    }
}
