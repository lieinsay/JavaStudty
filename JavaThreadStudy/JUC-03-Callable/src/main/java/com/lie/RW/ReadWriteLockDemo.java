package com.lie.RW;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
* ReadWriteLock
* 读-读   可以共存
* 读-写   不能共存
* 写-写   不能共存
* 独占锁（写锁）
* 共享锁（读锁）
* */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCacheLock myCache = new MyCacheLock();
        for (int i = 1; i <= 5; i++) {
            final int finalI = i;
            new Thread(() -> {
                myCache.put(String.valueOf(finalI), String.valueOf(finalI));
            }, String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5; i++) {
            final int finalI = i;
            new Thread(() -> {
                myCache.get(String.valueOf(finalI));
            }, String.valueOf(i)).start();
        }
    }
}

// 加锁
class MyCacheLock {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    // 存，写，只希望同时只有一个线程写
    public void put(String key, Object value) {
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入ok");
        } catch (Exception e) {

        } finally {
            lock.writeLock().unlock();
        }
    }

    // 取，读，所有人都可以读
    public void get(String key) {
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取ok");
        } catch (Exception e) {

        } finally {
            lock.readLock().unlock();
        }
    }
}

// 未加锁
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    // 存，写
    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入ok");

    }

    // 取，读
    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "读取" + key);
        map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取ok");
    }
}