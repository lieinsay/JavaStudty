package com.lie.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask,"A").start();
        System.out.println(futureTask.get());
        new Thread(futureTask,"B").start();
        System.out.println(futureTask.get());
    }
}

class MyThread implements Callable<String>{
    private int i = 0;
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+i++);
        return "StringJAVA"+i;
    }
}
