package read_write;

import javax.swing.plaf.TableHeaderUI;

public class ReaderThread extends Thread {
    private final Data data;
    public ReaderThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName() + "reads " + String.valueOf(readBuf));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
