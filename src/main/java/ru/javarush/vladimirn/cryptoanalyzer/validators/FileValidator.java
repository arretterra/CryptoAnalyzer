package ru.javarush.vladimirn.cryptoanalyzer.validators;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileValidator {

    public static boolean notExists(Path path) {
        boolean exists = Files.exists(path);
        if (!exists) {
            System.err.println("File not found. Try another one.");
            System.out.println("You can type \"dir\" to peek into the working directory.");
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
