package ru.javarush.vladimirn.cryptoanalyzer.controllers;

import ru.javarush.vladimirn.cryptoanalyzer.commands.Action;
import ru.javarush.vladimirn.cryptoanalyzer.commands.BruteForce;
import ru.javarush.vladimirn.cryptoanalyzer.commands.Decoder;
import ru.javarush.vladimirn.cryptoanalyzer.commands.Encoder;
import ru.javarush.vladimirn.cryptoanalyzer.exceptions.AppException;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTEFORCE(new BruteForce());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String actionName) {
        try {
            Actions value = Actions.valueOf(actionName.toUpperCase());
            return value.action;
        } catch (IllegalArgumentException e) {
            throw new AppException("Couldn't find such action.", e);
        }
    }
}
