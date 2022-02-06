package concurrency;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {

    private int MAX_SIZE = 10;
    private Queue<E> queue;
    // Add lock for thread safety
    private ReentrantLock lock;
    private Condition notFull;
    private Condition notEmpty;

    public MyBlockingQueue(int MAX_SIZE) {
        this.queue = new ArrayDeque<>();
        this.MAX_SIZE = MAX_SIZE;
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }

    public void put(E e) {
        // Acquire lock
        lock.lock();
        try {
            if (queue.size() >= MAX_SIZE) {
                // the not full condition will block
                notFull.await();
                // this means it will release the lock
                // for the producer and allow consumer to consume
            }
            queue.add(e);
            // then signal all threads the queue is not empty
            notEmpty.signalAll();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public E take() {
        lock.lock();
        try {
            if (queue.size() <= 0) {
                // we cannot consume more
                notEmpty.await();
            }
            // signal all threads the queue is not full
            notFull.signalAll();
            return queue.remove();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            lock.unlock();
        }
    }

    public Queue<E> getQueue() {
        return queue;
    }
}
