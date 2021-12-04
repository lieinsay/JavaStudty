import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo01 {
    public static void main(String[] args) {
        // 单个线程
//         ExecutorService threadExecutor = Executors.newSingleThreadExecutor();
        // 创建一个固定的线程池大小
//         ExecutorService threadExecutor = Executors.newFixedThreadPool(5);
        // 可伸缩的，遇强则强，遇弱则弱
        ExecutorService threadExecutor = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 10; i++) {
                threadExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ok");
                });
            }
        }catch (Exception e){

        }finally {
            // 线程池用完，程序结束，关闭线程池
            threadExecutor.shutdown();
        }
    }
}