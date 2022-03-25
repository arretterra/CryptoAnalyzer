package ru.javarush.vladimirn.cryptoanalyzer.constants;

public class Strings {

    public static final String WELCOME_MESSAGE = """
            Welcome to CryptoAnalyzer!
            I can encrypt and decrypt txt files using Caesar cipher.
            No problem if you have no encryption key, because i can brute force it.
            This program is a project for JavaRush University.
            Enjoy and stay safe!
            🄯
                            
            """;
    public static final String RERUN_MESSAGE = "Press Enter to rerun the program.";
    public static final String NOT_ENOUGH_ARGS = """
            Not enough program arguments.
            Executing console mode.""";
    public static final String START_THE_PROGRAM = "\nPress Enter to start the program.";
    public static final String TO_QUIT_MESSAGE = "Or type anything to quit.";
    public static final String KEY_NOT_FOUND = "Key not found.";
    public static final String FILE_NOT_FOUND = "File not found. Try another one.";
    public static final String DIR_PROMT = "You can type \"dir\" to peek into the working directory.";
    public static final String KEY_REQUEST = "Type an encryption key.\n" +
            "Or press Enter to randomly generate it.";
    public static final String CHOSEN_ACTION = "Chosen action: %s%n";
    public static final String WORKING_DIRECTORY = "Working directory is: " + Constants.TXT_FOLDER + "\n";
    public static final String FILE_NAME_REQUEST = "Type name of an %1$s file.%n" +
            "Or press Enter for default \"%1$s.txt\".";
    public static final String FILE_NAME_RESULT = "%s file is: %s%n";
    public static final String KEY_RESULT = "With key: %s%n";
    public static final String ACTION_REQUEST = "Type an action you want to perform.\n" +
            "(encode/decode/bruteforce or press Enter for encode)";
    public static final String CANT_RECOGNIZE_ACTION = "Can't recognize action, try again.";
    public static final String ACTION_COMPLETE = "Your %sd file is ready: %s";
    public static final String DECODED_FAIL_VALIDATION = "Decoding complete, but it looks like the key was incorrect. " +
            "Sending file to BruteForce.";
    public static final String DIRECTORY_CHOOSE_WISELY = "Ok, here is your files in working directory. Choose wisely.";
    public static final String WHICH_FILE = "So which file contains our input text?";
}
