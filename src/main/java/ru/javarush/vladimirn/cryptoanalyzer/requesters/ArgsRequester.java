package ru.javarush.vladimirn.cryptoanalyzer.requesters;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.loopers.InputFileLooper;

public class ArgsRequester {

    public static String[] request() {
        String[] args = new String[4];
        args[0] = ActionRequester.request();
        System.out.println("Chosen action: " + args[0]);
        System.out.println("Working directory is: " + Constants.TXT_FOLDER + "\n");
        System.out.println("Type name of an input file.\n" +
                "Or press Enter for default \"input.txt\".");
        args[1] = InputFileLooper.request();
        System.out.println("Input file is: " + Constants.TXT_FOLDER + args[1] + "\n");
        System.out.println("Type name of an output file.\n" +
                "Or press Enter for default \"output.txt\".");
        args[2] = FileNameRequester.request(true);
        System.out.println("Output file will be: " + Constants.TXT_FOLDER + args[2] + "\n");
        if (args[0].equalsIgnoreCase("encode") || args[0].equalsIgnoreCase("decode")) {
            args[3] = KeyRequester.request();
            System.out.println("With key: " + args[3] + "\n");
        }
        return args;
    }

}
