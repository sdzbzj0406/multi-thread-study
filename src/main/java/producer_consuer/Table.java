package producer_consuer;

import java.util.Arrays;

public class Table {

    private final String[] buffer;

    private int tail;

    private int head;

    private int count;

    public Table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public synchronized void put (String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "  puts   " + cake);
        while (count >= buffer.length) {
            wait();
        }

        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count ++;
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            System.out.println("wait before: " + Thread.currentThread().isInterrupted());
            wait();
            System.out.println("name: " + Thread.currentThread().getState());
        }

        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count -- ;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes  " + cake);
        return cake;
    }

    public synchronized void clear() {
        count = 0 ;
        head = 0;
        tail = 0;
        Arrays.fill(buffer, null);

        // 注意要提醒，不然很多线程会一直等待下去
        notifyAll();
    }

}
