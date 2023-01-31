package com.panda.designPattern._03_singletonPattern;

public class Singleton_register_sync {
    //静态对象仅创建一次
    private static class SingleHolder{
        private static final Singleton_register_sync INSTANCE = new Singleton_register_sync();
    }
    private Singleton_register_sync(){

    }

    public static final Singleton_register_sync getInstance(){
        return SingleHolder.INSTANCE;
    }
    public void showMessage(){
        System.out.println("Singleton_register_sync");
    }
}
