import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo01 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sms();
        }, "A").start();
        new Thread(() -> {
            phone.sms();
        }, "B").start();
    }
}

class Phone {

    Lock lock = new ReentrantLock();

    public synchronized void sms() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " sms");
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void call() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
