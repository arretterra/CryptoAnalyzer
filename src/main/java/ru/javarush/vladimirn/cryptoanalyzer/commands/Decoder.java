package ru.javarush.vladimirn.cryptoanalyzer.commands;

import ru.javarush.vladimirn.cryptoanalyzer.controllers.MainController;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Coder;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Key;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;
import ru.javarush.vladimirn.cryptoanalyzer.entity.ResultCode;
import ru.javarush.vladimirn.cryptoanalyzer.exceptions.AppException;
import ru.javarush.vladimirn.cryptoanalyzer.generators.BufferedStringGenerator;
import ru.javarush.vladimirn.cryptoanalyzer.generators.FilePathNameGenerator;
import ru.javarush.vladimirn.cryptoanalyzer.constants.Strings;
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
        String inputFileName = FileValidator.validateExtension(parameters[0]);
        String resultFileName = FileValidator.validateExtension(parameters[1]);
        try {
            Coder.code(key, inputFileName, resultFileName);
        } catch (IOException e) {
            throw new AppException("Decoding failed.", e);
        }
        try (BufferedReader bufferedReader = Files.newBufferedReader(
                Path.of(FilePathNameGenerator.generatePathName(inputFileName)))) {
            String generated = BufferedStringGenerator.generate(key.getValue(), bufferedReader);
            if (!TextValidator.validate(generated)) {
                System.out.println(Strings.DECODED_FAIL_VALIDATION);
                MainController mainController = new MainController();
                return mainController.doAction("bruteforce", parameters);
            }
        } catch (IOException e) {
            throw new AppException("I've got an error while validating encoded file.", e);
        }
        System.out.printf(Strings.ACTION_COMPLETE, "decode",
                FilePathNameGenerator.generatePathName(resultFileName));
        return new Result("Decoding successful. With key = " + key.getValue() + ".", ResultCode.ALL_WENT_GOOD);
    }
}
