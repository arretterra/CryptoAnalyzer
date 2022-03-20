package ru.javarush.vladimirn.cryptoanalyzer.entity;


import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Coder {

    public static void run(Key key, String input, String output) throws IOException {
        Path inputTxt = Path.of(Constants.TXT_FOLDER + input);
        Path outputTxt = Path.of(Constants.TXT_FOLDER + output);
        try (BufferedReader bufferedReader = Files.newBufferedReader(inputTxt);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(outputTxt)) {
            while (bufferedReader.ready()) {
                char[] buffer = new char[1024];
                int length = bufferedReader.read(buffer, 0, 1024);
                char[] coded = code(buffer, length, key);
                bufferedWriter.write(coded, 0, length);
                bufferedWriter.flush();
            }
        }
    }


    public static char[] code(char[] input, int length, Key key) {
        HashMap<Character, Character> cipher = key.getCipher();
        char[] output = new char[length];
        for (int i = 0; i < output.length; i++) {
            if (cipher.containsKey(input[i])) {
                output[i] = cipher.get(input[i]);
            } else {
                output[i] = input[i];
            }
        }
        return output;
    }

}
