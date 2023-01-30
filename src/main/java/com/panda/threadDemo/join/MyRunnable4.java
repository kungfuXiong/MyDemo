package com.panda.threadDemo.join;

public class MyRunnable4 implements Runnable{
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName()+"---"+i);
        }
    }
}
