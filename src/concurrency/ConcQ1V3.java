package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Solve with ScheduledExecutorService
public class ConcQ1V3 {

    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        service.schedule(service::shutdown, 5, TimeUnit.SECONDS);
    }

}
