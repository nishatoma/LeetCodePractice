package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample2 {

    public static void main(String[] args) {
        // Use executor service but with cached
        // thread pool.
        // Unlike fixed size thread pool, we dont pass any arguments
        // because it will just kill inactive threads, and add
        // a new thread to the synchronized queue.
        ExecutorService service = Executors.newCachedThreadPool();

        // Now run 100 tasks
        for (int i = 0; i < 100; ++i) {
            service.execute(new Task());
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }
    }
}
