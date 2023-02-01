package com.qinglan.threadDemo.automic;

public class test {
    static class myInt {
        int num;
        /*
        i++操作分为3step，step1：读i;step2:自增;step2:赋值
         */
        public int getNum() {
            return num++;
        }
    }

    public static void main(String[] args) {
         final myInt num = new myInt();

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                    while (true){
                        System.out.println(Thread.currentThread().getName()+" "+num.getNum());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }).start();
        }
    }
}
