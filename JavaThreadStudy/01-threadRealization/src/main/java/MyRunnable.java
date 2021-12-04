// 方式二：实现runnable接口,重写run方法，执行线程需要丢入runnable接口实现类.调用start方法
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我是线程MyRunnable"+i);
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        // 通过线程对象来代理自己的线程
        Thread thread = new Thread(myRunnable);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("我是主线程"+i);
        }
    }
}
