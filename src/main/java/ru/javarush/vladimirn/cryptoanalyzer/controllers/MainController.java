package ru.javarush.vladimirn.cryptoanalyzer.controllers;

import ru.javarush.vladimirn.cryptoanalyzer.commands.Action;
import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;

public class MainController {

    public Result doAction(String actionName, String[] parameters) {
        Action action = Actions.find(actionName);
        return action.execute(parameters);
    }
}
