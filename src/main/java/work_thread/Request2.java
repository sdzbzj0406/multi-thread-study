package work_thread;

import java.util.Random;

public class Request2 extends Request {
    private final Random random = new Random();
    public Request2(String name, int number) {
        super(name, number);
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + "req2  executes " + this);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
        }
    }
}
