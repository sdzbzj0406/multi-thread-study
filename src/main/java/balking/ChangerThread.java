package balking;

import java.io.IOException;
import java.util.Random;

/**
 * @author zhangjie59
 * @date 2021/3/2 22:32
 **/
public class ChangerThread extends Thread{

    private final Data data;

    private final Random random = new Random();

    ChangerThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        try {
            for (int i = 0; true; i++) {
                // 修改数据
                data.change("No." + i);
                // 执行其他操作
                Thread.sleep(random.nextInt(1000));
                // 主动执行保存操作
                data.save();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
