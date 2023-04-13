package com.xbl.juc;

public class test01 {

    public static void main(String[] args) throws InterruptedException {

        String s = "aaa";
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s) {
                    try {
                        System.out.println("你准备好了就叫我哦");
                        s.wait();
                        System.out.println("我拿到了");
                        s.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s) {
                    try {
                        System.out.println("你准备好了就叫我哦1");
                        s.wait();
                        System.out.println("我拿到了1");
                        s.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("准备zhong");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("准备好了，来拿吧");
                    s.notifyAll();
                    try {
                        s.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("拿到了是吧");
                }
            }
        });

        a.start();
        b.start();
        c.start();
    }
}
