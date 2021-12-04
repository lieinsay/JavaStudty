// 管程法——生产者和消费者
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Thread(new Producer(container)).start();
        new Thread(new Consumer(container)).start();

    }
}

// 生产者
class Producer implements Runnable {
    SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i+1));
        }
    }
}

// 消费者
class Consumer implements Runnable {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.pop();
        }
    }
}

// 产品
class Chicken {
    private int id;

    public Chicken(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

// 缓冲区
class SynContainer {
    // 容器
    Chicken[] chickens = new Chicken[10];
    // 容器计数器
    int count = 0;

    // 生产者放入产品
    public synchronized void push(Chicken chicken) {
        // 如果容器满了，需要等待消费者消费
        if (count>0) {
            // 通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 生产需要的时间
//        try {
//            this.wait(300);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // 容器没有满，我们就丢入产品
        System.out.println("生产了第"+chicken.getId()+"鸡");
        chickens[count] = chicken;
        count++;
        // 可以通知消费者消费
        this.notify();
    }

    // 消费者消费产品
    public synchronized Chicken pop() {
        // 如果容器空了，需要等待消费者消费
        if (count == 0) {
            // 通知生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 消费需要的时间
//        try {
//            this.wait(300);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // 容器有东西，我们就消费产品
        count--;
        System.out.println("消费了第"+chickens[count].getId()+"鸡");
        // 可以通知生产者生成
        this.notify();
        return chickens[count];
    }
}