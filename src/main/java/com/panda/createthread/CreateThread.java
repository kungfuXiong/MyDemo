package com.panda.createthread;

public class CreateThread {
    public static void main(String[] args) {
        System.out.println("现在所处的为主线程");
        //创建子线程
        MyThread thread = new MyThread();
        //启动子线程
        thread.start();
        /*调用start()方法后并不会真的启动，实际的启动时间是由线程调度器决定的
            子线程会执行run方法内部的代码
            多线程的运行结果与代码执行的顺序无关
        */
        System.out.println("主线程剩余的代码");
    }
}
