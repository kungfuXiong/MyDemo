package com.panda.threadDemo.interrupt;

public class TestInterrupt {
    public static void main(String[] args) {
        Thread subThread = new Thread(new MyRunnable());
        subThread.setName("subThread");
        subThread.start();
        //休眠5秒，期望5秒内，subThread的run方法执行结束
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //实际上subThread的run方法需要1年才能执行结束，此处使用interrupt来打断subThread的sleep状态，但是会抛出异常
        //不推荐使用stop方法，会导致丢失数据
        subThread.interrupt();

    }
}
