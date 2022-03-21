package ru.javarush.vladimirn.cryptoanalyzer.generators;

import ru.javarush.vladimirn.cryptoanalyzer.entity.Coder;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Key;
import java.io.BufferedReader;
import java.io.IOException;

public class BFAttemptGenerator {

    public static String generate(int keyValue, BufferedReader bufferedReader) throws IOException {
        Key key = Key.getKey(keyValue);
        char[] read = new char[8192];
        int length = bufferedReader.read(read, 0, 8192);
        return new String(Coder.codeOneBuffer(read, length, key));
    }

}
