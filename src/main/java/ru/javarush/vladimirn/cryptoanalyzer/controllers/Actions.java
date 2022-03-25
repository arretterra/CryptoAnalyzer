package ru.javarush.vladimirn.cryptoanalyzer.controllers;

import ru.javarush.vladimirn.cryptoanalyzer.commands.Action;
import ru.javarush.vladimirn.cryptoanalyzer.commands.BruteForce;
import ru.javarush.vladimirn.cryptoanalyzer.commands.Decoder;
import ru.javarush.vladimirn.cryptoanalyzer.commands.Encoder;
import ru.javarush.vladimirn.cryptoanalyzer.requesters.ActionRequester;

@SuppressWarnings("unused")
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
            System.err.println("Couldn't find such action.\n");
            Actions value = Actions.valueOf(ActionRequester.request().toUpperCase());
            return value.action;
        }
    }
}
