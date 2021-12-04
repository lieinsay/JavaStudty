// 信号灯法——标志位
public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Thread(new Performer(tv)).start();
        new Thread(new Viewer(tv)).start();
    }
}

// 生产者
class Performer implements Runnable {
    TV tv;

    public Performer(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            if(i%2==0){
                tv.play("电影"+i);
            }else{
                tv.play("广告"+i);
            }
        }
    }
}

// 消费者
class Viewer implements Runnable {
    TV tv;

    public Viewer(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

// 产品
class TV {
    private int id;
    private String voice;
    boolean flag = true;

    public synchronized void play(String voice){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了："+voice+"节目");
        // 通知观众观看
        this.voice = voice;
        this.flag = !this.flag;
        this.notify();
    }

    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看了："+voice+"节目");
        // 通知演员表演
        this.flag = !this.flag;
        this.notify();
    }
}