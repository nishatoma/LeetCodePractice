package heap;

import java.util.PriorityQueue;

public class SeatManager {
    private PriorityQueue<Integer> q;

    public SeatManager(int n) {
        // min queue
        q = new PriorityQueue<>();
        while (n != 0) {
            q.offer(n--);
        }
    }

    public int reserve() {
        return q.poll();
    }

    public void unreserve(int seatNumber) {
        q.offer(seatNumber);
    }
}
