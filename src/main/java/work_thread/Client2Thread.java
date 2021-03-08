package work_thread;

public class Client2Thread extends ClientThread{
    private final Channel channel;
    public Client2Thread(String name, Channel channel) {
        super(name, channel);
        this.channel = channel;
    }

    @Override
    public void run() {
        for (int i = 0; true; i++) {
            Request2 request2 = new Request2(getName(), i);
            channel.putRequest(request2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
