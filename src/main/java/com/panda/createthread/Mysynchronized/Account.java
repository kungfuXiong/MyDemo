package com.panda.createthread.Mysynchronized;

public class Account {
    // 实例变量。（Account对象是多线程共享的，Account对象中的实例变量obj也是共享的。）
    private double accountNo;
    private String name;
    Object o = new Object();

    public Account() {
    }

    public Account(double accountNo, String name) {
        this.accountNo = accountNo;
        this.name = name;
    }

    public double getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(double accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void withdraw(double money) {
        synchronized (o) {
            double before = this.accountNo;
            if (before < 500) {
                System.out.println("余额不足");
            } else {
                double after = before - money;
                this.setAccountNo(after);
                System.out.println(Thread.currentThread().getName() + this.getName() + "取款:" + money + ",余额为" + this.getAccountNo());
            }
        }
    }

    public void deposit(double money) {
//        synchronized (this)
//        synchronized (name)
        synchronized (o) {
            double before = this.accountNo;
            this.accountNo = before + money;
        }
    }
}
