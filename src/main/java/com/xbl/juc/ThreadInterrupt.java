package com.xbl.juc;
import java.util.Scanner;

public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        //线程0 用于执行循环输出
        T t = new T();
        Thread thread = new Thread(t);

        Thread thread1 = new Thread(()->{
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("输入您的指令（Q）表示退出");
                if ("Q".equals(scanner.next())){
                    System.out.println("指令通过");
                    t.loop = false;
                    break;
                }
            }
        });
        thread1.start();
        Thread.sleep(1000);
        thread.start();
    }

    static class T implements Runnable{
        boolean loop = true;
        @Override
        public void run() {
            while (loop){
                System.out.println( (int)(Math.random()*100+1));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("不能再摆烂啦");
                }
            }
        }
    }
}
