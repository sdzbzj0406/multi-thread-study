package producer_consuer;

import java.util.concurrent.Exchanger;

public class Main2 {
    public static void main(String[] args) {
        Exchanger<char[]> exchanger = new Exchanger<char[]>();
        char[] buffer = new char[10];
        char[] buffer2 = new char[10];

        new ProduceThread(exchanger, buffer, 314159).start();
        new ConsumerThread(exchanger, buffer2, 265358).start();
    }
}
