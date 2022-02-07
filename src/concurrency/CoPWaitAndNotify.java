package concurrency;

import java.util.Scanner;

public class CoPWaitAndNotify {

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread running");
            // Every object in java has a wait method
            // releases the internal lock of this synchronized lock
            wait();
            System.out.println("Resumed.");
        }
    }

    public void consume() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this) {
            System.out.println("Waiting for return key");
            sc.nextLine();
            System.out.println("Return key pressed");
            // tell the other thread to wake up,
            // dont get confused, this doesn't mean it will
            // run the other thread immediately!
            notify();
            Thread.sleep(5000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final CoPWaitAndNotify processor = new CoPWaitAndNotify();

        Thread t1 = new Thread(() -> {
            try {
                processor.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                processor.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
