package com.panda.createthread.isalive;

public class test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread();
        System.out.println(thread.isAlive());
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.isAlive());
    }
}
