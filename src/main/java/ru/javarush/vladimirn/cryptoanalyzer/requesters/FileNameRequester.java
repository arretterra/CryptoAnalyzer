package ru.javarush.vladimirn.cryptoanalyzer.requesters;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.printers.DirectoryPrinter;
import ru.javarush.vladimirn.cryptoanalyzer.validators.FileValidator;

public class FileNameRequester {

    public static String request() {
        return request(false);
    }

    protected static String request(boolean output) {
        String fileName;
        fileName = Constants.SCANNER.nextLine();
        if ("dir".equals(fileName)) {
            DirectoryPrinter.print();
            fileName = Constants.SCANNER.nextLine();
        }
        if (("".equals(fileName) || fileName.matches("\\s+")) && !output) {
            fileName = "input.txt";
        } else if (("".equals(fileName) || fileName.matches("\\s+"))) {
            fileName = "output.txt";
        } else {
            fileName = FileValidator.validateExtension(fileName);
        }
        return fileName;
    }
}
