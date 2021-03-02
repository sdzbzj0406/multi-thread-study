package balking;

/**
 * @author zhangjie59
 * @date 2021/3/2 22:34
 **/
public class Main {

    public static void main(String[] args) {
        Data data = new Data("data.txt", "(empty)");
        new ChangerThread("ChangerThread", data).start();
        new ServerThread("ServerThread", data).start();
    }
}
