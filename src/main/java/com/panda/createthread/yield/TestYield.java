package com.panda.createthread.yield;

public class TestYield {
    public static void main(String[] args) {
        MyRunnable3 myRunnable3 = new MyRunnable3();
        Thread thread = new Thread(myRunnable3);
        thread.setName("sub");
        thread.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName()+"++++"+i);
        }
    }
}
