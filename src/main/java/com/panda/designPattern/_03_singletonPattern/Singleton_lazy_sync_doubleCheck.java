package com.panda.designPattern._03_singletonPattern;

public class Singleton_lazy_sync_doubleCheck {
    //无法解决反序列化会破坏单例的问题。
    private static volatile Singleton_lazy_sync_doubleCheck instance;

    private Singleton_lazy_sync_doubleCheck() {
    }

    public static Singleton_lazy_sync_doubleCheck getInstance() {
        if (instance == null) {
            synchronized (Singleton_lazy_sync_doubleCheck.class) {
                if (instance == null) {
                    instance = new Singleton_lazy_sync_doubleCheck();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton_lazy_sync_doubleCheck");
    }
}
