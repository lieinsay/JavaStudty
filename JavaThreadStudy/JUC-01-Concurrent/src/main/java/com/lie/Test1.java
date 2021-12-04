package com.lie;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) ticket.sale();
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) ticket.sale();
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) ticket.add();
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) ticket.add();
        }, "D").start();
    }
}

class Ticket {
    private int num = 0;
    private int id = 0;

    public synchronized void sale() {
        // 加锁
        try {
            // 等待
            while (num == 0) {
                this.wait();
            }
            System.out.println(Thread.currentThread().getName() + "卖出了第" + (++id) + "票，剩余:" + (--num));
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }

    }

    public synchronized void add() {
        // 加锁
        try {
            // 等待
            while (num > 0) {
                this.wait();
            }
            System.out.println(Thread.currentThread().getName() + "添加了一张票，剩余:" + ++num);
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }

}
