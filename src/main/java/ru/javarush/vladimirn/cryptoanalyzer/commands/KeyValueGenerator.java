package ru.javarush.vladimirn.cryptoanalyzer.commands;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;

public class KeyValueGenerator {

    public static int generate(String inputKey) {
        byte[] bytes = inputKey.getBytes();
        int count = 0;
        for (byte aByte : bytes) {
            String bites = Integer.toBinaryString(aByte);
            for (int j = 0; j < bites.length(); j++) {
                if ('1' == bites.charAt(j)) {
                    count++;
                }
            }
        }
        return count % Constants.getLength();
    }

}
