package lock;

import java.util.concurrent.atomic.AtomicReference;

// 线程安全
public class lockThread {
    public static void main(String[] args) {
        AtomicReference<Integer> ticketNums = new AtomicReference<>(10);
        lockThread ticket = new lockThread();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticketNums.get() > 0){
                    System.out.println(Thread.currentThread().getName() +
                            " see  ticket for" +
                            ticketNums.getAndSet(ticketNums.get())
                    );
                }else {
                    break;
                }
            }
        },"看票员").start();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (ticketNums){
                        if (ticketNums.get() > 0){
                            System.out.println(Thread.currentThread().getName() +
                                    " get ticket for" +
                                    ticketNums.getAndSet(ticketNums.get() - 1)
                            );
                        }else {
                            break;
                        }
                    }
                }
            },"name"+i).start();
        }
    }
}
