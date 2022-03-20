package ru.javarush.vladimirn.cryptoanalyzer.commands;

import ru.javarush.vladimirn.cryptoanalyzer.entity.Coder;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Key;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;
import ru.javarush.vladimirn.cryptoanalyzer.entity.ResultCode;
import ru.javarush.vladimirn.cryptoanalyzer.exceptions.AppException;

import java.io.IOException;

public class Encoder implements Action {

    @Override
    public Result execute(String[] parameters) {
        Key key = Key.getKey(parameters[2], true);
        try {
            Coder.run(key, parameters[0], parameters[1]);
        } catch (IOException e) {
            throw new AppException("Encoding failed.", e);
        }
        return new Result("Encoding successful.", ResultCode.OK);
    }

}
