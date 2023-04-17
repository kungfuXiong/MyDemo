package com.xbl.juc;

import com.xbl.fileoperate.FileUpload;

import java.util.concurrent.*;
import java.util.function.Function;

public class SomeTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = new CompletableFuture<>();

        System.out.println("主线程启动：" + Thread.currentThread().getName());
        //同步调用
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("子线程启动：" + Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println("子线程完成：" + Thread.currentThread().getName());

            } catch (Exception e) {
                System.out.println("系统异常：" + e);
            }
            return 10;
        }).thenApply(u -> u * u).thenApply(u -> u * u);

        new Thread(() -> {
            try {
                System.out.println("子线程启动：" + Thread.currentThread().getName());
                Thread.sleep(3000);
                future1.complete("我完事了");
                System.out.println("子线程完成：" + Thread.currentThread().getName());
            } catch (Exception e) {
                System.out.println("系统异常：" + e);
            }
        }).start();
        System.out.println(future.get());//获取回调，会阻塞主线程
        System.out.println(future1.get());//获取回调，会阻塞主线程
        System.out.println("主线程结束：" + Thread.currentThread().getName());


        //异步调用
        Future<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " future");
            return 1000;
        });
        //合并
        CompletableFuture<Integer> future4 = future.thenCompose(integer -> CompletableFuture.supplyAsync(() -> integer + 1000));

        //获取结果
        System.out.println("主线程结束，future结果为：" + future3.get());
        System.out.println("主线程结束，future1合并结果为：" + future4.get());

    }

}
