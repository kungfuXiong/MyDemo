package com.xbl.juc;

import java.util.concurrent.CountDownLatch;

public class ReadWriteLockTest {
    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLockMap readWriteLockMap = new ReentrantReadWriteLockMap();

        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()-> {
                System.out.println(readWriteLockMap.put(String.valueOf(finalI), finalI % 5));
                latch.countDown();
            }).start();
        }

        latch.await();

        System.out.println(readWriteLockMap.get("9"));

        System.out.println(readWriteLockMap.put("xiongbl", 25));

        System.out.println(readWriteLockMap.get("xiongbl"));
    }
}
