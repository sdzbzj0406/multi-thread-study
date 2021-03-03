package producer_consuer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Table table = new Table(3);
        new MarkerThread("MarkerThread-1", table, 31415).start();
        new MarkerThread("MarkerThread-2", table, 92653).start();
        new MarkerThread("MarkerThread-3", table, 58979).start();

        new EaterThread("EaterThread-1", table, 32384).start();
        new EaterThread("EaterThread-2", table, 62643).start();
        new EaterThread("EaterThread-3", table, 38327).start();

        //10秒后，所有线程终止，执行所有线程的中断方法即可

    }
}
