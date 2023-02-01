package com.qinglan.threadDemo.method2;

public class CreateMyThread {
    public static void main(String[] args) {
        System.out.println("现在所处的为主线程");
        //创建runnable接口的实现对象
        MyRunnable myRunnable = new MyRunnable();
        //创建子线程
        Thread thread = new Thread(myRunnable);
        //启动子线程
        thread.start();
        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + "等待0.5秒");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        /*调用start()方法后并不会真的启动，实际的启动时间是由线程调度器决定的
            子线程会执行run方法内部的代码
            多线程的运行结果与代码执行的顺序无关
        */
        System.out.println("主线程剩余的代码");
    }
}
