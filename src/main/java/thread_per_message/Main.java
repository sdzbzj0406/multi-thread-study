package thread_per_message;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author zhangjie59
 * @date 2021/3/6 22:59
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host host = new Host(new Executor() {
            public void execute(Runnable command) {
                new Thread(command).start();;
            }
        });
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');

        System.out.println("main END");

    }
}
