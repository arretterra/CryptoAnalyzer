package ru.javarush.vladimirn.cryptoanalyzer.commands;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import java.util.HashMap;

public class KeyCipherGenerator {

    private static final char[] alphabet = Constants.ALPHABET;

    public static HashMap<Character, Character> generate(int key, boolean encode) {
        HashMap<Character, Character> cipher = new HashMap<>();
        if (encode) {
            for (int i = 0; i < alphabet.length; i++) {
                int shift = key + i;
                if (shift >= alphabet.length) {
                    shift -= alphabet.length;
                }
                cipher.put(alphabet[i], alphabet[shift]);
            }
        } else {
            for (int i = 0; i < alphabet.length; i++) {
                int shift = key + i;
                if (shift >= alphabet.length) {
                    shift -= alphabet.length;
                }
                cipher.put(alphabet[shift], alphabet[i]);
            }
        }
        return cipher;
    }
}
