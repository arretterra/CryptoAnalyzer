package ru.javarush.vladimirn.cryptoanalyzer.commands;

import ru.javarush.vladimirn.cryptoanalyzer.entity.Coder;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Key;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;
import ru.javarush.vladimirn.cryptoanalyzer.entity.ResultCode;
import ru.javarush.vladimirn.cryptoanalyzer.exceptions.AppException;
import ru.javarush.vladimirn.cryptoanalyzer.constants.Strings;
import ru.javarush.vladimirn.cryptoanalyzer.generators.FilePathNameGenerator;
import ru.javarush.vladimirn.cryptoanalyzer.validators.FileValidator;
import ru.javarush.vladimirn.cryptoanalyzer.validators.KeyValidator;

import java.io.IOException;

public class Encoder implements Action {

    @Override
    public Result execute(String[] parameters) {
        String keyValue = KeyValidator.exists(parameters);
        Key key = Key.getKey(keyValue, true);
        String inputFileName = FileValidator.validateExtension(parameters[0]);
        String resultFileName = FileValidator.validateExtension(parameters[1]);
        try {
            Coder.code(key, inputFileName, resultFileName);
        } catch (IOException e) {
            throw new AppException("Encoding failed.", e);
        }
        System.out.printf(Strings.ACTION_COMPLETE, "encode",
                FilePathNameGenerator.generatePathName(resultFileName));
        return new Result("Encoding successful. With key = " + key.getValue() + ".", ResultCode.ALL_WENT_GOOD);
    }

}
