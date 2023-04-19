package com.xbl.juc;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocals {
    public static void main(String[] args) throws InterruptedException {
        //单一线程池
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(5);



        //InheritableThreadLocal存储
//        InheritableThreadLocal<String> username = new InheritableThreadLocal<>();


        executorService= TtlExecutors.getTtlExecutorService(executorService);
        //TransmittableThreadLocal创建
        TransmittableThreadLocal<String> username = new TransmittableThreadLocal<>();

        for (int i = 0; i < 10; i++) {
            username.set("InheritableThreadLocal 的问题—" + i);
            Thread.sleep(3000);
            CompletableFuture.runAsync(()-> System.out.println(username.get()),executorService);
        }
    }
}
