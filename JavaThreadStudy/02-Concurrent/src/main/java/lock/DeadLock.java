package lock;

public class DeadLock {
    public static void main(String[] args) {
        Makeup makeup1 = new Makeup(0,"1");
        Makeup makeup2 = new Makeup(1,"2");
        new Thread(makeup1).start();
        new Thread(makeup2).start();
    }
}

class Lipstick {

}

class Mirror {

}

class Makeup implements Runnable {

    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String name;

    public Makeup(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        makeup();
    }

    private void makeup() {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println("获得口红的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror) {
                    System.out.println("获得镜子的锁");
                }
            }
        } else {
            synchronized (mirror) {
                System.out.println("获得镜子的锁");
                synchronized (lipstick) {
                    System.out.println("获得口红的锁");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}