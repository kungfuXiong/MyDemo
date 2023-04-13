package com.xbl.juc;

import lombok.extern.slf4j.Slf4j;
import lombok.var;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class test03 {

    public static void main(String[] args) {

        IncreaseSyn increaseSyn = new IncreaseSyn();
        IncreaseLock increaseLock = new IncreaseLock();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                increaseSyn.increment();
                increaseLock.increment();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                increaseSyn.decrement();
                increaseLock.decrement();
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


    @Slf4j
    static class IncreaseLock {
        private int number = 0;
        private ReentrantLock reentrantLock = new ReentrantLock();
        private Condition condition = reentrantLock.newCondition();

        /**
         * 加一
         */
        public void increment() {
            reentrantLock.lock();
            try {
                while (number != 0) {
                    condition.await();
                }
                number++;
                log.info("[IncreaseLock] " + Thread.currentThread().getName() + "：加1成功，值为：" + number);
                condition.signalAll();
            } catch (Exception e) {
                log.error("[IncreaseLock] 系统异常：" + e);
            } finally {
                reentrantLock.unlock();
            }
        }

        /**
         * 减一
         */
        public void decrement() {
            reentrantLock.lock();
            try {
                while (number == 0) {
                    condition.await();
                }
                number--;
                log.info("[IncreaseLock] " + Thread.currentThread().getName() + "：减1成功，值为：" + number);
                condition.signalAll();
            } catch (Exception e) {
                log.error("[IncreaseLock] 系统异常：" + e);
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}

