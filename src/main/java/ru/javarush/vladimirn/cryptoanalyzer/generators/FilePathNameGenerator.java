package ru.javarush.vladimirn.cryptoanalyzer.generators;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;

public class FilePathNameGenerator {
    public static String generatePathName(String fileName) {
        return Constants.TXT_FOLDER + fileName;
    }
}
