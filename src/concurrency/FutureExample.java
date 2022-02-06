package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class FutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Call the service to return a future
        // Get number of available processors
        int cores = Runtime.getRuntime().availableProcessors();
        // Executor service
        ExecutorService service = Executors.newFixedThreadPool(cores);

        // use the service
        // store 100 futures in an array list
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < 20_000; i++) {
            Future<Integer> future = service.submit(new Task());
            futures.add(future);
        }

        IntStream.of(1000).forEach(i -> {

        });


        // Shutdown the service
        service.shutdown();
        futures.forEach((future) -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        new Thread(new Task2()).start();
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }

    static class Task2 implements Runnable {


        @Override
        public void run() {

        }
    }
}
