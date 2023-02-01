package com.qinglan.threadDemo.interrupt;

public class MyRunnable2 implements Runnable{

    boolean flag = true;
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (flag){
                System.out.println(Thread.currentThread().getName()+"----"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                System.out.println("xbl");
                return;
            }

        }
    }
}
