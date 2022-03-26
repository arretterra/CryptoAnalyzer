package ru.javarush.vladimirn.cryptoanalyzer.constants;

import java.io.File;
import java.util.Scanner;

public class Constants {

    private static final String RUS_ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = ".,\"':-!? ";

    public static final char[] ALPHABET = (RUS_ALPHABET + RUS_ALPHABET.toLowerCase() + DIGITS + SYMBOLS).toCharArray();
    public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "text" + File.separator;
    public static final Scanner SCANNER = new Scanner(System.in);
}
