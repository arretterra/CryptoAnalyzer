package ru.javarush.vladimirn.cryptoanalyzer.commands;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Coder;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Key;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;
import ru.javarush.vladimirn.cryptoanalyzer.entity.ResultCode;
import ru.javarush.vladimirn.cryptoanalyzer.exceptions.AppException;
import ru.javarush.vladimirn.cryptoanalyzer.generators.BufferedStringGenerator;
import ru.javarush.vladimirn.cryptoanalyzer.validators.FileValidator;
import ru.javarush.vladimirn.cryptoanalyzer.validators.TextValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce implements Action {
    @Override
    public Result execute(String[] parameters) {
        boolean success = false;
        int keyValue = -1;
        Path inputTxt = Path.of(Constants.TXT_FOLDER + FileValidator.validateExtension(parameters[0]));
        while (!success) {
            try (BufferedReader bufferedReader = Files.newBufferedReader(inputTxt)) {
                bufferedReader.mark(8192);
                keyValue++;
                String generated = BufferedStringGenerator.generate(keyValue, bufferedReader);
                success = TextValidator.validate(generated);
                bufferedReader.reset();
                if (success && keyValue == 0) {
                    return new Result("That file wasn't even encoded! :/ So there is no need for creating " +
                            FileValidator.validateExtension(parameters[1]), ResultCode.ALL_WENT_GOOD);
                }
                if (!success && keyValue > Constants.getAlphabetLength()) {
                    return new Result("Bruteforce failed :(.", ResultCode.FAILED);
                }
            } catch (IOException e) {
                throw new AppException("I've got error while reading file for brute forcing.", e);
            }
        }
        Key key = Key.getKey(keyValue);
        try {
            Coder.code(key, FileValidator.validateExtension(parameters[0]),
                    FileValidator.validateExtension(parameters[1]));
        } catch (IOException e) {
            throw new AppException("BruteForcing failed while decoding with key=" + key.getValue() + ".", e);
        }
        System.out.println("Your brute forced file is ready: " + Constants.TXT_FOLDER
                + FileValidator.validateExtension(parameters[1]));
        return new Result("BruteForcing successful with key=" + key.getValue() + ".", ResultCode.ALL_WENT_GOOD);
    }



}
