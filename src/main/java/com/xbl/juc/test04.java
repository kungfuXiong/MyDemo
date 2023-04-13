package com.xbl.juc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class test04 {

    private static int num = 0;
    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static Condition conditionA = reentrantLock.newCondition();
    private static Condition conditionB = reentrantLock.newCondition();
    private static Condition conditionC = reentrantLock.newCondition();


    public static void printA(int j) {
        reentrantLock.lock();

        try {
            while (num != 0) {
                conditionA.await();
            }
            log.info(Thread.currentThread().getName() + "打印A第" + j + "次");
            for (int i = 0; i < 5; i++) {
                log.info("A");
            }
            num = 1;
            conditionB.signalAll();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }

    }

    private static void printB(int j) {
        reentrantLock.lock();

        try {
            while (num != 1) {
                conditionB.await();
            }
            log.info(Thread.currentThread().getName() + "打印B第几" + j + "次");
            for (int i = 0; i < 10; i++) {
                log.info("B");
            }
            num = 2;
            conditionC.signalAll();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }

    }

    private static void printC(int j) {
        reentrantLock.lock();

        try {
            while (num != 2) {
                conditionC.await();
            }
            log.info(Thread.currentThread().getName() + "打印C第几" + j + "次");
            for (int i = 0; i < 15; i++) {
                log.info("C");
            }
            num = 0;
            conditionA.signalAll();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                printA(i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                printB(i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                printC(i);
            }
        }).start();

        Thread.sleep(10000);
        log.info("输出完成");
    }
}
