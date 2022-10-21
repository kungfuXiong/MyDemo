package com.panda.createthread.join;

public class TestJoin {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable4());
        thread.setName("sub");
        thread.start();

        try {
            thread.join(0,1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("main is over");

    }
}
