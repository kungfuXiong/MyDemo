package com.xbl.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class cowArrrayList {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1000);
        List<String> array = new ArrayList<>(1100);

        // 开启100个线程递增
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    String s = UUID.randomUUID().toString();
                    log.info(s);
                    array.add(s);
                } catch (Exception e) {
                    log.error("多线程递增异常，" + e);
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        // 倒计时锁存器 CountDownLatch
        try {
            latch.await();
        } catch (Exception e) {
            log.error("多线程递增异常，" + e);
        }

        log.info("子线程都执行完毕，继续执行主线程");
        log.info("array=" + array.size());
    }

//    public static void main(String[] args) throws InterruptedException {
//        List<String> array = new ArrayList<>(1100);
//        for (int i = 0; i < 1000; i++) {
//            new Thread(() -> {
//
//                    String s = UUID.randomUUID().toString();
//                    log.info(s);
//                    array.add(s);
//            }).start();
//        }
//        Thread.sleep(5000);
//        System.out.println(array.size());
//    }
}
