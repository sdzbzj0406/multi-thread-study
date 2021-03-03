package producer_consuer;

import java.util.concurrent.ArrayBlockingQueue;

public class Table_ABQ extends ArrayBlockingQueue<String> {
    public Table_ABQ(int capacity) {
        super(capacity);
    }

    public void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "  puts   " + cake);
        super.put(cake);

    }

    public String get() throws InterruptedException {
        String cake = super.take();
        System.out.println(Thread.currentThread().getName() + " takes  " + cake);
        return cake;
    }

}
