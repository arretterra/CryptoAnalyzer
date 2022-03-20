package ru.javarush.vladimirn.cryptoanalyzer.commands;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Coder;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Key;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;
import ru.javarush.vladimirn.cryptoanalyzer.entity.ResultCode;
import ru.javarush.vladimirn.cryptoanalyzer.exceptions.AppException;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce implements Action {
    @Override
    public Result execute(String[] parameters) {
        boolean success = false;
        int keyValue = -1;
        Path inputTxt = Path.of(Constants.TXT_FOLDER + parameters[0]);
        while (!success) {
            try (BufferedReader bufferedReader = Files.newBufferedReader(inputTxt)) {
                bufferedReader.mark(8192);
                keyValue++;
                Key key = Key.getKey(keyValue);
                char[] read = new char[8192];
                int length = bufferedReader.read(read, 0, 8192);
                String temp = new String(Coder.code(read, length, key));
                success = Validate.run(temp);
                bufferedReader.reset();
                if (success && keyValue == 0) {
                    return new Result("That file wasn't even encoded! :/ So there is no need for creating " +
                            "bruteforced.txt.", ResultCode.OK);
                }
            } catch (IOException e) {
                throw new AppException("I've got error while reading file for brute forcing.", e);
            }
        }
        Key key = Key.getKey(keyValue);
        try {
            Coder.run(key, parameters[0], parameters[1]);
        } catch (IOException e) {
            throw new AppException("BruteForcing failed while decoding with key=" + key.getValue() + ".", e);
        }
        return new Result("BruteForcing successful with key=" + key.getValue() + ".", ResultCode.OK);
    }

}
