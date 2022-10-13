package com.example.challenge_quality.util;

public class NumberGenerator {

    private int next;
    private final static NumberGenerator instance = new NumberGenerator();

    private NumberGenerator() {

    }

    public static NumberGenerator getInstance() {
        return instance;
    }

    public int getNext() {
        return ++next;
    }
}
