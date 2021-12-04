public class SleepThread implements Runnable{
    private int ticketNums = 10;

    public int getTicketNums() {
        return ticketNums;
    }

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) break;
            System.out.println(Thread.currentThread().getName()+" get ticket for" + ticketNums--);
        }
    }

    public static void main(String[] args) {
        SleepThread ticket = new SleepThread();
        new Thread(ticket,"name_a").start();
        new Thread(ticket,"name_b").start();
        new Thread(ticket,"name_c").start();
    }
}
