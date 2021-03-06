package thread_per_message;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author zhangjie59
 * @date 2021/3/6 22:59
 **/
public class Host {
    private final Helper helper = new Helper();
    private final Executor executor;

    public Host(Executor executor) {
        this.executor = executor;
    }

    public void request(final int count, final  char c) {
        System.out.println("request (" + count + "," + c + ") BEGIN");

//        new Thread() {
//            @Override
//            public void run() {
//                helper.handle(count, c);
//            }
//        }.start();

        executor.execute(
                new Runnable() {
                    public void run() {
                        helper.handle(count, c);
                    }
                }
        );

        System.out.println("request (" + count + "," + c + ") END");

    }
}
