package com.panda.createthread.interrupt;

public class MyRunnable implements Runnable{
    public void run() {
        Thread.currentThread().setName("subThread->start");
        try {
            Thread.sleep(1000*60*60*24*12);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("subThread->end");
    }
}
