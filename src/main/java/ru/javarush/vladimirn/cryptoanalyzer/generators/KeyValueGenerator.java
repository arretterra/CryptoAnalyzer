package ru.javarush.vladimirn.cryptoanalyzer.generators;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;

public class KeyValueGenerator {

    public static int generate(String inputKey) {
        int result;
        try {
            int temp = Integer.parseInt(inputKey);
            result = Math.abs(temp % Constants.getLength());
        } catch (NumberFormatException e) {
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
            result = count % Constants.getLength();
        }
        return result;
    }

}
