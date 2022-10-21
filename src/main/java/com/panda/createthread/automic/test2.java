package com.panda.createthread.automic;

import java.util.concurrent.atomic.AtomicInteger;

public class test2 {
    public static void main(String[] args) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                    while (true){

                        int andIncrement = atomicInteger.getAndIncrement();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(Thread.currentThread().getName()+" "+ andIncrement);
                    }
                }
            }).start();
        }
    }
}
