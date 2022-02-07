package concurrency;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner2 {

    private Account acc1 = new Account();
    private Account acc2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private static void acquireLocks(Lock firstLock, Lock secondLock) {
        while (true) {
            boolean acquiredFirstLock = false;
            boolean acquiredSecondLock = false;

            try {
                acquiredFirstLock = firstLock.tryLock();
                acquiredSecondLock = secondLock.tryLock();
            } finally {
                if (acquiredFirstLock && acquiredSecondLock) {
                    return;
                }

                if (acquiredFirstLock) {
                    firstLock.unlock();
                }

                if (acquiredSecondLock) {
                    secondLock.unlock();
                }
            }
        }
    }

    public void firstThread() throws InterruptedException {
        Random random = new Random();

        for (int i = 0; i < 10_000; i++) {
            acquireLocks(lock1, lock2);
            try {
                Account.transfer(acc1, acc2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() throws InterruptedException {
        Random random = new Random();

        for (int i = 0; i < 10_000; i++) {
            acquireLocks(lock2, lock1);
            try {
                Account.transfer(acc2, acc1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println("Account 1 balance: " + acc1.getBalance());
        System.out.println("Account 2 balance: " + acc2.getBalance());
        System.out.println("Total : " + (acc2.getBalance() + acc1.getBalance()));
    }

    public static void main(String[] args) throws InterruptedException {
        Runner2 runner = new Runner2();

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
