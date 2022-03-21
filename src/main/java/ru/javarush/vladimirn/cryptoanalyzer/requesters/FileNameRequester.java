package ru.javarush.vladimirn.cryptoanalyzer.requesters;

import ru.javarush.vladimirn.cryptoanalyzer.printers.DirectoryPrinter;

import java.util.Scanner;

public class FileNameRequester {

    protected static String run(Scanner sc) {
        return run(sc, false);
    }

    protected static String run(Scanner sc, boolean output) {
        String fileName;
        fileName = sc.nextLine();
        if (fileName.equals("dir")) {
            DirectoryPrinter.print();
            fileName = sc.nextLine();
        }
        if ((fileName.equals("") || fileName.matches("\\s+")) && !output) {
            fileName = "input.txt";
        } else if ((fileName.equals("") || fileName.matches("\\s+"))) {
            fileName = "output.txt";
        } else if (!fileName.endsWith(".txt")) {
            fileName = fileName + ".txt";
        }
        return fileName;
    }
}
