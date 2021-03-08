package work_thread;

public class Main {

    public static void main(String[] args) {

        Channel channel = new Channel(5);
        channel.startWorkers();
        new ClientThread("Alice", channel).start();
        new ClientThread("Bob", channel).start();
        new ClientThread("Chris", channel).start();
        new Client2Thread("zhangjie", channel).start();
    }


}
