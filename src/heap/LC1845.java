package heap;

import java.util.PriorityQueue;

public class LC1845 {
    PriorityQueue<Integer> seats;

    public LC1845(int n) {
        seats = new PriorityQueue<>();
        for (int i = n; i > 0; --i) {
            seats.offer(i);
        }
    }

    public int reserve() {
        return this.seats.poll();
    }

    public void unreserve(int seatNumber) {
        this.seats.offer(seatNumber);
    }
}
