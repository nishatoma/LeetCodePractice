package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {
        // Get a thread pool of size 10 using Service Executor
        // Number of threads depends on number of cores!
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of cores: " + coreCount);
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        // Then run the task 1000 times...
        for (int i = 0; i < 40; ++i) {
            // Execute the task
            service.execute(new Task());
        }
        // Shut down the service now
        service.shutdown();
        System.out.println("GG NAME: " + Thread.currentThread().getName());
    }


    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }
    }
}


