package ru.javarush.vladimirn.cryptoanalyzer.commands;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.controllers.MainController;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Coder;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Key;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;
import ru.javarush.vladimirn.cryptoanalyzer.entity.ResultCode;
import ru.javarush.vladimirn.cryptoanalyzer.exceptions.AppException;
import ru.javarush.vladimirn.cryptoanalyzer.validators.TextValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Decoder implements Action {

    @Override
    public Result execute(String[] parameters) {
        Key key = Key.getKey(parameters[2]);
        try {
            Coder.code(key, parameters[0], parameters[1]);
        } catch (IOException e) {
            throw new AppException("Decoding failed.", e);
        }
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(Constants.TXT_FOLDER
                + parameters[1]))) {
            char[] read = new char[8192];
            int length = bufferedReader.read(read, 0, 8192);
            String temp = new String(Coder.codeOneBuffer(read, length, key));
            if (!TextValidator.run(temp)) {
                System.out.println("Decoding complete, but it looks like the key was incorrect. " +
                        "Sending file to BruteForce.");
                MainController mainController = new MainController();
                return mainController.doAction("bruteforce", parameters);
            }
        } catch (IOException e) {
            throw new AppException("I've got an error while validating encoded file.", e);
        }
        System.out.println("Your decoded file is ready: " + Constants.TXT_FOLDER + parameters[1]);
        return new Result("Decoding successful.", ResultCode.ALL_WENT_GOOD);
    }
}
