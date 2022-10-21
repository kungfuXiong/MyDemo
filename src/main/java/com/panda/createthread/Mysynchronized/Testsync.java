package com.panda.createthread.Mysynchronized;

public class Testsync {
    public static void main(String[] args) {
        Account xiongl = new Account(10000, "xiongl");

        MyThread5 myThread1 = new MyThread5(xiongl);
        MyThread5 myThread2 = new MyThread5(xiongl);
        MyThread5 myThread3 = new MyThread5(xiongl);
        MyThread5 myThread4 = new MyThread5(xiongl);
        MyThread5 myThread5 = new MyThread5(xiongl);


        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();

    }
}
