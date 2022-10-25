package com.panda.createthread.yield;

public class TestYield {
    public static void main(String[] args) {
        MyRunnable3 myRunnable3 = new MyRunnable3();
        Thread thread = new Thread(myRunnable3);
        thread.setName("sub");
        //设置线程优先级
        thread.setPriority(10);
        thread.start();
        System.out.println(thread.getPriority());
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName()+"++++"+i);
        }
    }
}
