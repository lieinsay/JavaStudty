package CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;

public class demo01 {

    public static void main(String[] args) {
        AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<>("2020", 1);

        new Thread(() -> {
            System.out.println("A1=>" + atomicStampedReference.getStamp());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet("2020", "2022", atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("A2=>" + atomicStampedReference.getStamp());
            System.out.println(atomicStampedReference.compareAndSet("2022", "2020", atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("A3=>" + atomicStampedReference.getStamp());
        }, "A").start();
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("B1=>" + stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet("2020", "2066",
                    stamp, stamp + 1));
            System.out.println("B2=>" + atomicStampedReference.getStamp());
        }, "B").start();
    }
}
