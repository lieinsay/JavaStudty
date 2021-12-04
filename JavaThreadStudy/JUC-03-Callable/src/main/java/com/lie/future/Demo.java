package com.lie.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 异步调用：
 */
public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"runAsync");
//        });
//        System.out.println("1111111");
//
//        future.get();
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"supplyAsync=>Integer");
            return 1024/0;
        });

        System.out.println(completableFuture.whenComplete((t, u) -> {
            System.out.println(t + " " + u);
        }).exceptionally((throwable) -> {
            System.out.println(throwable.getMessage());
            return 233;
        }).get());
    }
}
