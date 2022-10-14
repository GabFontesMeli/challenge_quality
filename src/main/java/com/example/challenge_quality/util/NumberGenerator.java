package com.example.challenge_quality.util;

public class NumberGenerator {

    private int next;
    private final static NumberGenerator instance = new NumberGenerator();
    private final static NumberGenerator instanceProperty = new NumberGenerator();

    private NumberGenerator() {

    }

    public static NumberGenerator getInstance() {
        return instance;
    }

    public static NumberGenerator getInstanceProperty() {
        return instanceProperty;
    }

    public int getNext() {
        return ++next;
    }
}
