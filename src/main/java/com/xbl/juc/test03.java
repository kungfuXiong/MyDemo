package com.xbl.juc;

import lombok.extern.slf4j.Slf4j;

public class test03 {

    public static void main(String[] args) {

        IncreaseSyn increaseSyn = new IncreaseSyn();
//            IncreaseLock increaseLock = new IncreaseLock();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                increaseSyn.increment();
//                increaseLock.increment();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                increaseSyn.decrement();
//            increaseLock.decrement();
            }
        }).start();

    }

    @Slf4j
    static class IncreaseSyn {
        private int number = 0;

        /**
         * 加一
         */
        public synchronized void increment() {
            try {
                while (number != 0) {
                    this.wait();
                }
                number++;
                log.info("[IncreaseSyn] " + Thread.currentThread().getName() + "：加1成功，值为：" + number);
                notifyAll();
            } catch (Exception e) {
                log.error("[IncreaseSyn] 系统异常：" + e);
            }
        }

        /**
         * 减一
         */
        public synchronized void decrement() {
            try {
                while (number == 0) {
                    this.wait();
                }
                number--;
                log.info("[IncreaseSyn] " + Thread.currentThread().getName() + "：减1成功，值为：" + number);
                notifyAll();
            } catch (Exception e) {
                log.error("[IncreaseSyn] 系统异常：" + e);
            }
        }
    }
}

