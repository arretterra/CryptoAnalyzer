package ru.javarush.vladimirn.cryptoanalyzer.requesters;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;

import java.util.Scanner;

public class ArgsRequester {

    public static String[] run(Scanner sc) {
        System.out.println("Type an action you want to perform.\n" +
                "(encode/decode/bruteforce or press Enter for encode)");
        String[] args = new String[4];
        args[0] = ActionRequester.run(sc);
        System.out.println("Chosen action: " + args[0]);
        System.out.println("Working directory is: " + Constants.TXT_FOLDER + "\n");
        System.out.println("Type a name of input file.\n" +
                "Or press Enter for default \"input.txt\"");
        args[1] = FileNameRequester.run(sc);
        System.out.println("Input file is: " + Constants.TXT_FOLDER + args[1] + "\n");
        System.out.println("Type a name of output file.\n" +
                "Or press Enter for default \"output.txt\"");
        args[2] = FileNameRequester.run(sc, true);
        System.out.println("Output file is: " + Constants.TXT_FOLDER + args[2] + "\n");
        if (args[0].equalsIgnoreCase("encode") || args[0].equalsIgnoreCase("decode")) {
            System.out.println("Type an encryption key.\n" +
                    "Or press Enter to randomly generate it.");
            args[3] = KeyRequester.run(sc);
            System.out.println("With key: " + args[3] + "\n");
        }
        return args;
    }

}
