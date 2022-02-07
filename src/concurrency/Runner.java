package concurrency;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    private void increment() {
        for (int i = 0; i < 10_000; i++) {
            count++;
        }
    }

    public void firstThread() throws InterruptedException {
        lock.lock();

        // make this thread wait, hand over the lock
        System.out.println("waiting...");
        cond.await();

        System.out.println("woken up");

        try {
            System.out.println("incremented first thread");
            increment();
        } finally {
            System.out.println("Unlocked first thread");
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException {
        Thread.sleep(1000);
        lock.lock();

        System.out.println("Press return key");
        new Scanner(System.in).nextLine();
        System.out.println("pressed key");

        // wake the other thread up
        cond.signal();
        try {
            //
            System.out.println("Increased second thread");
            increment();
        } finally {
            System.out.println("unlocked second thread");
            lock.unlock();
        }
    }

    public void finished() {
        System.out.println("Count is: " + count);
    }

    public static void main(String[] args) throws InterruptedException {

        Runner runner = new Runner();

        Thread t1 = new Thread(() -> {
            try {
                runner.firstThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                runner.secondThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        runner.finished();
    }
}
