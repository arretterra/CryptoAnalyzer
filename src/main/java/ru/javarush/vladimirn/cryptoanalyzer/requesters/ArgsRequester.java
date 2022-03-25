package ru.javarush.vladimirn.cryptoanalyzer.requesters;

import ru.javarush.vladimirn.cryptoanalyzer.generators.FilePathNameGenerator;
import ru.javarush.vladimirn.cryptoanalyzer.loopers.InputFileLooper;
import ru.javarush.vladimirn.cryptoanalyzer.constants.Strings;

public class ArgsRequester {

    public static String[] request() {
        String[] args = new String[4];
        args[0] = ActionRequester.request();
        System.out.printf(Strings.CHOSEN_ACTION, args[0]);
        System.out.println(Strings.WORKING_DIRECTORY);
        System.out.printf(Strings.FILE_NAME_REQUEST, "input");
        args[1] = InputFileLooper.request();
        System.out.printf(Strings.FILE_NAME_RESULT, "input", FilePathNameGenerator.generatePathName(args[1]));
        System.out.printf(Strings.FILE_NAME_REQUEST, "output");
        args[2] = FileNameRequester.request(true);
        System.out.printf(Strings.FILE_NAME_RESULT, "output", FilePathNameGenerator.generatePathName(args[2]));
        if ("encode".equalsIgnoreCase(args[0]) || "decode".equalsIgnoreCase(args[0])) {
            args[3] = KeyRequester.request();
            System.out.printf(Strings.KEY_RESULT, args[3]);
        }
        return args;
    }

}
