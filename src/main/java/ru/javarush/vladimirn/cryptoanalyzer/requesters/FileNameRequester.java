package ru.javarush.vladimirn.cryptoanalyzer.requesters;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.printers.DirectoryPrinter;
import ru.javarush.vladimirn.cryptoanalyzer.validators.FileValidator;

import java.util.Scanner;

public class FileNameRequester {

    public static String request() {
        return request(false);
    }

    protected static String request(boolean output) {
        String fileName;
        Scanner scanner = Constants.SCANNER;
        fileName = scanner.nextLine();
        if (fileName.equals("dir")) {
            DirectoryPrinter.print();
            fileName = scanner.nextLine();
        }
        if ((fileName.equals("") || fileName.matches("\\s+")) && !output) {
            fileName = "input.txt";
        } else if ((fileName.equals("") || fileName.matches("\\s+"))) {
            fileName = "output.txt";
        } else {
            fileName = FileValidator.validateExtension(fileName);
        }
        return fileName;
    }
}
