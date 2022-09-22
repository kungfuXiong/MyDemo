package com.panda.createthread.automic;

public class test {
    static class myInt {
        int num;

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
