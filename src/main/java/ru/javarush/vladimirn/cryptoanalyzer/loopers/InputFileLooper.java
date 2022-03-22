package ru.javarush.vladimirn.cryptoanalyzer.loopers;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.requesters.FileNameRequester;
import ru.javarush.vladimirn.cryptoanalyzer.validators.FileValidator;

import java.nio.file.Path;

public class InputFileLooper {

    public static String request() {
        String fileName;
        do {
            fileName = FileNameRequester.request();
        } while (FileValidator.notExists(Path.of(Constants.TXT_FOLDER + fileName)));
        return fileName;
    }

    public static String check(String fileName) {
        while ((FileValidator.notExists(Path.of(Constants.TXT_FOLDER + fileName)))) {
            fileName = FileNameRequester.request();
        }
        return fileName;
    }
}
