// 创建线程方式一:继承Thread类，重写run()方法，调用start开启线程
public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我是线程MyThread"+i);
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("我是主线程"+i);
        }
    }
}
