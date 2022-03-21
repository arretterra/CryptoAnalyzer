package ru.javarush.vladimirn.cryptoanalyzer.requesters;

import java.util.Scanner;

public class FileNameRequester {

    protected static String run(Scanner sc) {
        return run(sc, false);
    }

    protected static String run(Scanner sc, boolean output) {
        String fileName;
        fileName = sc.nextLine();
        if ((fileName.equals("") || fileName.equals(" ")) && !output) {
            fileName = "input.txt";
        } else if ((fileName.equals("") || fileName.equals(" "))) {
            fileName = "output.txt";
        } else if (!fileName.endsWith(".txt")) {
            fileName = fileName + ".txt";
        }
        return fileName;
    }
}
