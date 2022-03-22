package ru.javarush.vladimirn.cryptoanalyzer.constants;

import java.io.File;
import java.util.Scanner;

public class Constants {

    private static final String rusAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String digits = "0123456789";
    private static final String symbols = ".,\"':-!? ";

    public static final char[] ALPHABET = (rusAlphabet + rusAlphabet.toLowerCase() + digits + symbols).toCharArray();
    public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "text" + File.separator;
    public static final Scanner SCANNER = new Scanner(System.in);

    public static int getLength() {
        return ALPHABET.length;
    }
}
