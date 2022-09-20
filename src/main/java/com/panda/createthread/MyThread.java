package com.panda.createthread;

/**
 * 定义一个类继承Thread类
 * 重写Run方法
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("这是子线程");
    }
}
