package ru.javarush.vladimirn.cryptoanalyzer.commands;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.controllers.MainController;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Coder;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Key;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;
import ru.javarush.vladimirn.cryptoanalyzer.entity.ResultCode;
import ru.javarush.vladimirn.cryptoanalyzer.exceptions.AppException;
import ru.javarush.vladimirn.cryptoanalyzer.generators.BufferedStringGenerator;
import ru.javarush.vladimirn.cryptoanalyzer.validators.FileValidator;
import ru.javarush.vladimirn.cryptoanalyzer.validators.KeyValidator;
import ru.javarush.vladimirn.cryptoanalyzer.validators.TextValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Decoder implements Action {

    @Override
    public Result execute(String[] parameters) {
        String keyValue = KeyValidator.exists(parameters);
        Key key = Key.getKey(keyValue);
        try {
            Coder.code(key, FileValidator.extensionValidate(parameters[0]),
                    FileValidator.extensionValidate(parameters[1]));
        } catch (IOException e) {
            throw new AppException("Decoding failed.", e);
        }
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(Constants.TXT_FOLDER
                + parameters[0]))) {
            String generated = BufferedStringGenerator.generate(key.getValue(), bufferedReader);
            if (!TextValidator.run(generated)) {
                System.out.println("Decoding complete, but it looks like the key was incorrect. " +
                        "Sending file to BruteForce.");
                MainController mainController = new MainController();
                return mainController.doAction("bruteforce", parameters);
            }
        } catch (IOException e) {
            throw new AppException("I've got an error while validating encoded file.", e);
        }
        System.out.println("Your decoded file is ready: " + Constants.TXT_FOLDER
                + FileValidator.extensionValidate(parameters[1]));
        return new Result("Decoding successful. With key = " + key.getValue() + ".", ResultCode.ALL_WENT_GOOD);
    }
}
