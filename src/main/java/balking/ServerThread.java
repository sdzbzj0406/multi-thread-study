package balking;

import java.io.IOException;

/**
 * @author zhangjie59
 * @date 2021/3/2 22:30
 **/
public class ServerThread extends Thread{

    private final Data data;

    ServerThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        try {
            while (true) {
                // 要求执行保存数据操作
                data.save();
                // 休眠约1秒钟
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
