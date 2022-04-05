package concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcQ1 {

    public static void main(String[] args) throws InterruptedException {
        // Start new thread/thread pool
        ExecutorService service = Executors.newFixedThreadPool(2);

        // Step 1: Start the thread
        Thread t1 = new Thread(() -> {
            // If someone called "interrupt" then return
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
        });
        t1.start();
        // Step 2: TODO: timeout for 10 minutes

        // Step 3: Stop the thread
        t1.interrupt();
    }


}
