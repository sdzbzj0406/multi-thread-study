package producer_consuer;

import java.util.Random;

public class MarkerThread extends Thread {

    private final Random random;

    private final Table table;

    public static int id = 0;

    public MarkerThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {

        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));
                String cake = "[Cake No." + nextId() + "   by " + getName() + "]";
                table.put(cake);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private synchronized static int nextId() {
        return id++;
    }


}
