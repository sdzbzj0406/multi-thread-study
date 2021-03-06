package thread_per_message;

/**
 * @author zhangjie59
 * @date 2021/3/6 22:59
 **/
public class Helper {
    public void handle(int count, char c) {
        System.out.println("handle(" + count + "," + c + ") BEGIN");
        for (int i = 0;i < count; i++) {
            slowy();
            System.out.println(c);
        }
        System.out.println("");
        System.out.println("handle(" + count + "," + c + ") END");
    }

    private void slowy() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
