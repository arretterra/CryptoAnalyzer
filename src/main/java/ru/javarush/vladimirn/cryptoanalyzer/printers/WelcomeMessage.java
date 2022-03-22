package ru.javarush.vladimirn.cryptoanalyzer.printers;

public class WelcomeMessage {

    public static void print() {
        System.out.println("""
                Welcome to CryptoAnalyzer!
                I can encrypt and decrypt txt files using Caesar cipher.
                No problem if you have no encryption key, because i can brute force it.
                This program is a project for JavaRush University.
                Enjoy and stay safe!
                🄯
                
                """);
    }
}
