package concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockBasics {

    private static final ReentrantLock lockA = new ReentrantLock();
    private static final ReentrantLock lockB = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(DeadLockBasics::processA);
        Thread t2 = new Thread(DeadLockBasics::processB);
        t1.start();
        t2.start();
    }

    static void processA() {
        // acquire lock A
        lockA.lock();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // acquire lock B
        lockB.lock();
        // unlock both
        lockA.unlock();
        lockB.unlock();
    }

    static void processB() {
        // acquire lock B
        lockB.lock();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // acquire lock A
        lockA.lock();
        // unlock both
        lockA.unlock();
        lockB.unlock();
    }
}
