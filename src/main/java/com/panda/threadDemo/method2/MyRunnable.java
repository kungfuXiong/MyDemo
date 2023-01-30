package com.panda.threadDemo.method2;

/**
 * 定义一个类继承Thread类
 * 重写Run方法
 */
public class MyRunnable implements Runnable {
    public MyRunnable() {
        System.out.println("构造方法"+Thread.currentThread().getName());
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
//                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName()+ "等待1秒");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
