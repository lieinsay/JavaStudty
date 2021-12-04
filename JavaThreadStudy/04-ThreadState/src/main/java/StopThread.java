public class StopThread implements Runnable {

    // 1.设置标识位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("run"+Thread.currentThread().getName()+i++);
            if(i==1000)break;
        }
    }

    // 2.设置一个公开的方法停止线程，转换标识位
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) throws InterruptedException {
        StopThread stopThread = new StopThread();
        Thread thread = new Thread(stopThread,"线程x");
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main"+i);
            if(i==900){
                // 自己的stop方法
//                stopThread.stop();
                // 已弃用
                // thread.stop();
                thread.join();
                System.out.println("testThread该停止了"+thread.isAlive());
            }
        }
        stopThread.stop();
    }
}
