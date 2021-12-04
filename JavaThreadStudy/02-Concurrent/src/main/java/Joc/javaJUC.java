package Joc;

import java.util.concurrent.CopyOnWriteArrayList;

public class javaJUC {
    public static void main(String[] args){
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
               list.add(Thread.currentThread().getName());
            }).start();
        }
        while (true){
            if(list.size()==100){
                System.out.println(list.size());
                break;
            }
            System.out.println(list.size());
        }

    }
}
