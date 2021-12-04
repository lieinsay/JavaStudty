package com.lie.add;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 12; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();// 等待计数器归零，然后再向下执行
        System.out.println("我可以动了");
    }
}