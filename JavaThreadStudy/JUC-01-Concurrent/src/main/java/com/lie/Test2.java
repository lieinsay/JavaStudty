package com.lie;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {
    public static void main(String[] args) {
        Ticket1 ticket = new Ticket1();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) ticket.sale0();
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) ticket.sale1();
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) ticket.add0();
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) ticket.add1();
        }, "D").start();
    }
}

class Ticket1 {
    private int num = 0;
    private int id = 0;
    Lock lock = new ReentrantLock();
    Condition buyCondition0 = lock.newCondition();
    Condition buyCondition1 = lock.newCondition();
    Condition addCondition = lock.newCondition();
    public void sale0() {
        // 加锁
        lock.lock();
        try {
            // 等待
            while (num == 0) {
                buyCondition0.await();
            }
            System.out.println(Thread.currentThread().getName() + "卖出了第" + (++id) + "票，剩余:" + (--num));
            addCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void sale1() {
        // 加锁
        lock.lock();
        try {
            // 等待
            while (num == 0) {
                buyCondition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "卖出了第" + (++id) + "票，剩余:" + (--num));
            addCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void add0() {
        // 加锁
        lock.lock();
        try {
            // 等待
            while (num > 0) {
                addCondition.await();
            }
            System.out.println(Thread.currentThread().getName() + "添加了一张票，剩余:" + ++num);
            buyCondition0.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void add1() {
        // 加锁
        lock.lock();
        try {
            // 等待
            while (num > 0) {
                addCondition.await();
            }
            System.out.println(Thread.currentThread().getName() + "添加了一张票，剩余:" + ++num);
            buyCondition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}