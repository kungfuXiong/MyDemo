package com.qinglan.designPattern._03_singletonPattern;

public class Singleton_lazy_sync {
    //静态对象仅创建一次
    private static Singleton_lazy_sync instance ;

    private Singleton_lazy_sync(){}

    public static synchronized Singleton_lazy_sync getInstance(){
        if (instance == null){
            instance = new Singleton_lazy_sync();
        }
        return instance;
    }

    public void showMessage(){
        System.out.println("Singleton_lazy_sync");
    }
}
