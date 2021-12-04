import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinlockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    // 加锁
    public void myLock(){
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null,thread)){
        }
        System.out.println(Thread.currentThread().getName() + "==>myLock");
    }

    // 解锁
    public  void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "==>myUnLock");
        atomicReference.compareAndSet(thread,null);
    }

    public static void main(String[] args) {
        SpinlockDemo lock = new SpinlockDemo();
        new Thread(()->{
            lock.myLock();
            try {
                System.out.println("A");
//                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.myUnLock();
            }
        },"A").start();
        new Thread(()->{
            lock.myLock();
            try {
                System.out.println("B");
//                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.myUnLock();
            }
        },"B").start();
    }
}
