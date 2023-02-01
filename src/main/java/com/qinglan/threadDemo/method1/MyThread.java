package com.qinglan.threadDemo.method1;

/**
 * 定义一个类继承Thread类
 * 重写Run方法
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("这是子线程");
        System.out.println("sub Thread 等待1秒");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
