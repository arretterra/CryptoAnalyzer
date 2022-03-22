package ru.javarush.vladimirn.cryptoanalyzer.commands;

import ru.javarush.vladimirn.cryptoanalyzer.constants.Constants;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Coder;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Key;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;
import ru.javarush.vladimirn.cryptoanalyzer.entity.ResultCode;
import ru.javarush.vladimirn.cryptoanalyzer.exceptions.AppException;
import ru.javarush.vladimirn.cryptoanalyzer.requesters.FileNameRequester;
import ru.javarush.vladimirn.cryptoanalyzer.validators.FileValidator;
import ru.javarush.vladimirn.cryptoanalyzer.validators.KeyValidator;

import java.io.IOException;
import java.nio.file.Path;

public class Encoder implements Action {

    @Override
    public Result execute(String[] parameters) {
        String keyValue = KeyValidator.exists(parameters);
        Key key = Key.getKey(keyValue, true);
        try {
            String inputFile = parameters[0];
            if (!FileValidator.exists(Path.of(Constants.TXT_FOLDER + parameters[0]))) {
                inputFile = FileNameRequester.run();
            }
            Coder.code(key, FileValidator.extensionValidate(inputFile),
                    FileValidator.extensionValidate(parameters[1]));
        } catch (IOException e) {
            throw new AppException("Encoding failed.", e);
        }
        System.out.println("Your encoded file is ready: " + Constants.TXT_FOLDER
                + FileValidator.extensionValidate(parameters[1]));
        return new Result("Encoding successful. With key = " + key.getValue() + ".", ResultCode.ALL_WENT_GOOD);
    }

}
