import java.util.concurrent.TimeUnit;

public class JMMDemo1 {
    private volatile static int num = 0;
    public static void main(String[] args){
        new Thread(()->{
            while (num==0){
//                System.out.println("0");
            }
        },"A").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num = 1;
            System.out.println("我改了num");
        },"B").start();
        System.out.println(num);
    }
}
