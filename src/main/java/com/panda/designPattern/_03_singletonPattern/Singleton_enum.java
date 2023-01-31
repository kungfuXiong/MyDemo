package com.panda.designPattern._03_singletonPattern;

public enum Singleton_enum {
    INSTANCE(1);
    private final int value;

    Singleton_enum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
