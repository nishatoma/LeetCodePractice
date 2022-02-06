package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcQ1V2 {

    // this time we use thread pool instead of single thread
    public static void main(String[] args) throws InterruptedException {
        // Executor Service
        ExecutorService service = Executors.newFixedThreadPool(2);

        // Step 1: Start the task
        service.submit(() -> {
           // Check if we are constantly interrupted
           // if not continue the task
           while (!Thread.currentThread().isInterrupted()) {
               // continue to do some task
           }
        });

        // Step 2: Shut down after 10 minutes
        // we can use thread sleep
        Thread.sleep(10 * 60 * 1000);
        // Step 3: shutdown when we are done
        // This call "interrupt" for each thread internally.
        service.shutdownNow();
    }
}
