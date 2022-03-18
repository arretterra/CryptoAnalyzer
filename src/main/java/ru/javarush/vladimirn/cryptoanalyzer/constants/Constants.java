package ru.javarush.vladimirn.cryptoanalyzer.constants;

import java.io.File;
import java.util.Locale;

public class Constants {

    private static final String rusAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String digits = "0123456789";
    private static final String symbols = ".,\"':-!? ";

    public static final char[] ALPHABET = (rusAlphabet + rusAlphabet.toLowerCase() + digits + symbols).toCharArray();
    //public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "text" + File.separator;
}
