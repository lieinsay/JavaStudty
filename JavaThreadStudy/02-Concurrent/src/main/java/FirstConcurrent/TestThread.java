package FirstConcurrent;

// 线程不安全
public class TestThread implements Runnable {

    private int ticketNums = 10;

    public int getTicketNums() {
        return ticketNums;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buy();
        }
    }
    public synchronized void buy(){
        if (ticketNums <= 0) return;
        System.out.println(Thread.currentThread().getName()+" get ticket for" + ticketNums--);
    }

    public static void main(String[] args) {

        TestThread ticket = new TestThread();
        new Thread(ticket,"name_a").start();
        new Thread(ticket,"name_b").start();
        new Thread(ticket,"name_c").start();
//        while (true)
//        System.out.println(ticket.getTicketNums());
    }
}
