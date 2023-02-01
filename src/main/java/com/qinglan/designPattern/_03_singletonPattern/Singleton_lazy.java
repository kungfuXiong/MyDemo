package com.qinglan.designPattern._03_singletonPattern;

public class Singleton_lazy {
    //静态对象仅创建一次
    private static Singleton_lazy instance ;

    private Singleton_lazy(){}

    public static Singleton_lazy getInstance(){
        if (instance == null){
            instance = new Singleton_lazy();
        }
        return instance;
    }

    public void showMessage(){
        System.out.println("Singleton_lazy");
    }
}
