package com.panda.threadDemo.interrupt;

public class TestStop {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable2 myRunnable2 = new MyRunnable2();
        Thread sub = new Thread(myRunnable2);
        sub.setName("sub");
        sub.join();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        Thread.yield();
        myRunnable2.flag=false;
    }
}

