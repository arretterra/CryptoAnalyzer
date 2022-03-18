package ru.javarush.vladimirn.cryptoanalyzer.entity;

public class Result {

    private final String message;

    private final ResultCode resultCode;


    public Result(String message, ResultCode resultCode) {
        this.message = message;
        this.resultCode = resultCode;
    }
}
