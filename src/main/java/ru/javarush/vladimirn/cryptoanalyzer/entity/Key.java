package ru.javarush.vladimirn.cryptoanalyzer.entity;

import ru.javarush.vladimirn.cryptoanalyzer.commands.KeyCipherGenerator;
import ru.javarush.vladimirn.cryptoanalyzer.commands.KeyValueGenerator;
import java.util.HashMap;

public class Key {

    private static Key key;

    private int value;
    private HashMap<Character, Character> cipher;

    private Key(String inputKey, boolean encode) {
        generateCipher(inputKey, encode);
    }

    private Key(int value) {
        this.value = value;
        generateCipherOnly(value);
    }

    public int getValue() {
        return value;
    }

    public HashMap<Character, Character> getCipher() {
        return cipher;
    }

    public static Key getKey(String inputKey) {
         return getKey(inputKey, false);
    }

    public static Key getKey(String inputKey, boolean encode) {
        if (key == null) {
            key = new Key(inputKey, encode);
        } else {
            key.generateCipher(inputKey, encode);
        }
        return key;
    }

    public static Key getKey(int value) {
        if (key == null) {
            key = new Key(value);
        } else {
            key.value = value;
            key.generateCipherOnly(value);
        }
        return key;
    }

    private void generateCipherOnly(int value) {
        this.cipher = KeyCipherGenerator.generate(value, false);
    }

    private void generateCipher(String inputKey, boolean encode) {
        this.value = KeyValueGenerator.generate(inputKey);
        this.cipher = KeyCipherGenerator.generate(value, encode);
    }

}
