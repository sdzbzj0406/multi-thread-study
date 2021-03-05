package read_write;

public class ReadWriteLock {

    private int readingReaders = 0;
    private int waitingWrites = 0;
    private int writingWrites = 0;
    private boolean preferWriter = true;

    public synchronized void readLock() throws InterruptedException {
        while (writingWrites > 0 || (preferWriter && waitingWrites > 0)) {
            wait();
        }
        readingReaders ++;
    }

    public synchronized void readUnlock() {
        readingReaders--;
        preferWriter = true;
        notifyAll();
    }

    public synchronized void writeLock() {
        waitingWrites++;
        try {
            while (readingReaders > 0 || writingWrites > 0) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            waitingWrites++;
        }
        writingWrites++;
    }

    public synchronized void writeUnlock() {
        writingWrites--;
        preferWriter = false;
        notifyAll();
    }


}
