package com.panda.createthread.Mysynchronized;

public class MyThread5 extends Thread{
    private Account account;

    public MyThread5(Account account) {
        this.account = account;
    }

    public MyThread5() {
    }

    public void run() {
        double money = 500;
        account.withdraw(money);
        System.out.println(Thread.currentThread().getName()+account.getName()+"取款:"+money+",余额为"+account.getAccountNo());
    }
}
