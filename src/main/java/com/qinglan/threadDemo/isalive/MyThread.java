package com.qinglan.threadDemo.isalive;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().isAlive());
    }
}
