import java.util.concurrent.*;

public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("我是线程MyRunnable"+i);
        }
        return (int)(Math.random()*100);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable1 = new MyCallable();
        MyCallable myCallable2 = new MyCallable();
        MyCallable myCallable3 = new MyCallable();
        MyCallable myCallable4 = new MyCallable();
        // 创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(4);

        // 提交执行
        Future<Integer> future1 = service.submit(myCallable1);
        Future<Integer> future2 = service.submit(myCallable2);
        Future<Integer> future3 = service.submit(myCallable3);
        Future<Integer> future4 = service.submit(myCallable4);
        // 获取结果
        int result1 = future1.get();
        int result2 = future2.get();
        int result3 = future3.get();
        int result4 = future4.get();
        // 关闭服务
        service.shutdown();
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);

        for (int i = 0; i < 10; i++) {
            System.out.println("我是主线程"+i);
        }

    }
}
