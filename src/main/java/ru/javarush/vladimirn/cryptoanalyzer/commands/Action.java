package ru.javarush.vladimirn.cryptoanalyzer.commands;

import ru.javarush.vladimirn.cryptoanalyzer.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
