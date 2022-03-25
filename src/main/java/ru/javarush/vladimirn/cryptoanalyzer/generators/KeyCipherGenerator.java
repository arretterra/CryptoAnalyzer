package ru.javarush.vladimirn.cryptoanalyzer.generators;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;

import java.util.HashMap;

public class KeyCipherGenerator {


    public static HashMap<Character, Character> generate(int key, boolean encode) {
        HashMap<Character, Character> cipher = new HashMap<>();
        for (int i = 0; i < Constants.ALPHABET.length; i++) {
            int shift = key + i;
            if (shift >= Constants.ALPHABET.length) {
                shift -= Constants.ALPHABET.length;
            }
            if (encode) {
                cipher.put(Constants.ALPHABET[i], Constants.ALPHABET[shift]);
            } else {
                cipher.put(Constants.ALPHABET[shift], Constants.ALPHABET[i]);
            }
        }
        return cipher;
    }
}
