package ru.javarush.vladimirn.cryptoanalyzer.validators;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileValidator {

    public static boolean exists(Path path) {
        boolean success = Files.exists(path);
        if (!success) {
            System.out.println("""
                    File not found. Try another one.
                    You can type "dir" to peek into the working directory.""");
        }
        return success;
    }

}
