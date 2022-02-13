package concurrency;

import java.util.concurrent.Semaphore;

public class Connection {

    private static Connection instance = new Connection();

    private Semaphore sem = new Semaphore(10, true);

    private int connections = 0;

    private Connection(){}

    public static Connection getInstance() {
        return instance;
    }

    public void makeConnection() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // make the connection
        try {
            this.connect();
        } finally {
            sem.release();
        }
    }

    public void connect() {
        synchronized (this) {
            connections++;
            System.out.println("Connections: " + connections);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            connections--;
        }
    }
}
