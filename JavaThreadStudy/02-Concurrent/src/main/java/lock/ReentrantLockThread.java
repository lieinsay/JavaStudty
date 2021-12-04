package lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockThread {
    public static void main(String[] args) {
        TicketLockThread ticketLockThread = new TicketLockThread();
        new Thread(ticketLockThread,"1").start();
        new Thread(ticketLockThread,"2").start();
        new Thread(ticketLockThread,"3").start();
    }
}

class TicketLockThread implements Runnable{

    private final ReentrantLock lock = new ReentrantLock();

    private int ticketNums = 10;

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            if(ticketNums>0){
                System.out.println(Thread.currentThread().getName()+" get "+ticketNums--);
                lock.unlock();
            }else {
                lock.unlock();
                break;
            }

        }
    }
}
