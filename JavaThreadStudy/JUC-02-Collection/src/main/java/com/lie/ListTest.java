package com.lie;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

// java.util.ConcurrentModificationException 并发修改异常
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        Collections.synchronizedList(new ArrayList<>());
        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,4));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
