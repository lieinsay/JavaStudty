import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;
    private Long temp = 10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    /*
     * 1、ForkJoinPool 通过这个来执行
     * 2、ForkJoinPool的execute(ForkJoinTask task)方法计算任务
     * 3、计算类要继承ForkJoinTask的实现
     */
    // 计算方法
    @Override
    protected Long compute() {
        if ((end - start) > temp) {
            Long sum = 0L;
            for (Long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = start + (end - start) / 2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            // 拆分任务，把任务压入线程队列
            task1.fork();
            ForkJoinDemo task2 = new ForkJoinDemo(middle + 1, end);
            task2.fork();
            return task1.join() + task2.join();
        }
    }

    public static void main(String[] args) {
        test3();
    }

    public static void test1(){
        long start = System.currentTimeMillis();
        Long sum = 0L;
        for (Long i = 0L; i < 10_0000_0000; i++) {
            sum+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 用时："+(end-start));
        // 用时：7191
    }

    public static void test2(){
        long start = System.currentTimeMillis();
        Long sum = 0L;
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L,10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        try {
            sum = submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 用时："+(end-start));
        // 用时：10219（太吃cpu了）
    }

    public static void test3(){
        long start = System.currentTimeMillis();
        Long sum = 0L;
        // Stream 并行流
        // range(,)     rangeClosed(,]

        sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 用时："+(end-start));
        // 用时：213 算法
    }
}
