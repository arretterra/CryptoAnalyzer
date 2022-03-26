package ru.javarush.vladimirn.cryptoanalyzer.commands;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Coder;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Key;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;
import ru.javarush.vladimirn.cryptoanalyzer.entity.ResultCode;
import ru.javarush.vladimirn.cryptoanalyzer.exceptions.AppException;
import ru.javarush.vladimirn.cryptoanalyzer.generators.BufferedStringGenerator;
import ru.javarush.vladimirn.cryptoanalyzer.generators.FilePathNameGenerator;
import ru.javarush.vladimirn.cryptoanalyzer.constants.Strings;
import ru.javarush.vladimirn.cryptoanalyzer.generators.MessageGenerator;
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
        String inputFileName = FileValidator.validateExtension(parameters[0]);
        String resultFileName = FileValidator.validateExtension(parameters[1]);
        Path inputTxt = Path.of(FilePathNameGenerator.generatePathName(inputFileName));
        while (!success) {
            try (BufferedReader bufferedReader = Files.newBufferedReader(inputTxt)) {
                bufferedReader.mark(8192);
                keyValue++;
                String generated = BufferedStringGenerator.generate(keyValue, bufferedReader);
                success = TextValidator.validate(generated);
                bufferedReader.reset();
                if (success && keyValue == 0) {
                    return new Result(Strings.NOT_ENCODED +
                            resultFileName, ResultCode.ALL_WENT_GOOD);
                }
                if (!success && keyValue == Constants.ALPHABET.length) {
                    return new Result(Strings.BRUTE_FORCE_FAILED, ResultCode.FAILED);
                }
            } catch (IOException e) {
                throw new AppException(Strings.READING_FILE_ERROR, e);
            }
        }
        Key key = Key.getKey(keyValue);
        try {
            Coder.code(key, inputFileName, resultFileName);
        } catch (IOException e) {
            throw new AppException(MessageGenerator.failMessage("Bruteforce", key), e);
        }
        System.out.printf(Strings.ACTION_COMPLETE, "bruteforce",
                FilePathNameGenerator.generatePathName(resultFileName));
        return new Result(MessageGenerator.successMessage("Bruteforce", key), ResultCode.ALL_WENT_GOOD);
    }


}
