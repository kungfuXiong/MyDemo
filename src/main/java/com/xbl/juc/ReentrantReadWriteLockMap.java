package com.xbl.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 可重入读写锁
 * 场景: 使用 ReentrantReadWriteLock 对一个 hashmap 进行读和写操作
 * hashmap本身是线程不安全的，若需要安全集合可以采用concurrentHashMap
 * 或者是对hashmap加锁操作
 *
 * @author zrj
 * @since 2021/8/20
 **/
public class ReentrantReadWriteLockMap {

    private volatile Map<String, Object> map = new HashMap<>(16);

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public boolean put(String key, Object value) {
        readWriteLock.writeLock().lock();
        String threadName = Thread.currentThread().getName();
        try {
            System.out.println(threadName + "正在进行写操作{"+"key:"+ key +" value: " + value + "}");
            map.put(key, value);
            TimeUnit.MICROSECONDS.sleep(800);
            System.out.println(threadName + "写入完成");
            return true;
        } catch (Exception e) {
            System.out.println("写入异常" + e.getMessage());
            return false;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public Object get(String key) {
        readWriteLock.readLock().lock();
        String threadName = Thread.currentThread().getName();
        try {
            System.out.println(threadName + "正在进行读操作{"+"key:"+ key + "}");
            Object o = map.get(key);
            System.out.println(threadName + "读完成");
            return o;
        } catch (Exception e) {
            System.out.println("读取异常" + e.getMessage());
            return null;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }



}

