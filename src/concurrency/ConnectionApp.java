package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConnectionApp {

    public static void main(String[] args) throws InterruptedException {


        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 200; i++) {
            service.submit(() -> {
                Connection.getInstance().makeConnection();
            });
        }

        service.shutdown();
        // shutdown after 1 day
        service.awaitTermination(1, TimeUnit.DAYS);
    }
}
