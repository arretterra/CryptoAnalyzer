package ru.javarush.vladimirn.cryptoanalyzer.loopers;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.requesters.FileNameRequester;
import ru.javarush.vladimirn.cryptoanalyzer.validators.FileValidator;

import java.nio.file.Path;

public class InputFileLooper {

    public static String execute() {
        String fileName;
        do {
            fileName = FileNameRequester.run();
        } while (!FileValidator.exists(Path.of(Constants.TXT_FOLDER + fileName)));
        return fileName;
    }

    public static String execute(String fileName) {
        while ((!FileValidator.exists(Path.of(Constants.TXT_FOLDER + fileName)))) {
            fileName = FileNameRequester.run();
        }
        return fileName;
    }
}
