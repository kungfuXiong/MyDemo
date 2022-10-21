package com.panda.createthread.yield;

public class MyRunnable3 implements Runnable{

    public void run() {
        for (int i = 0; i < 10000; i++) {
            if (i%100 == 0){
                Thread.yield();
            }else {
                System.out.println(Thread.currentThread().getName()+"-----"+i);
            }

        }
    }
}
