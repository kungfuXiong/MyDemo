package com.qinglan.designPattern._03_singletonPattern;

public class Singleton_hungry_sync {
    //静态对象仅创建一次
    private static Singleton_hungry_sync instance = new Singleton_hungry_sync();

    private Singleton_hungry_sync(){}

    public static  Singleton_hungry_sync getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Singleton_hungry_sync");
    }
}
