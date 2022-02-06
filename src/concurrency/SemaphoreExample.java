package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {

    public static void main(String[] args) throws InterruptedException {
        // int permits
        int permits = 3;
        // core count
        int cores = Runtime.getRuntime().availableProcessors();
        // Executor Service
        ExecutorService service = Executors.newFixedThreadPool(cores);

        // Semaphore
        Semaphore semaphore = new Semaphore(permits);

        for (int i = 0; i < 100; i++) {
            service.execute(new Task(semaphore));
        }

        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
    }

    static class Task implements Runnable {

        private final Semaphore semaphore;

        public Task(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            semaphore.acquireUninterruptibly();
            // Some task
            semaphore.release();
        }
    }
}
