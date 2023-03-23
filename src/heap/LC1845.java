package heap;

import java.util.PriorityQueue;

public class LC1845 {
    PriorityQueue<Integer> seats;
    int smallest;

    public LC1845(int n) {
        seats = new PriorityQueue<>();
        smallest = 1;
    }

    public int reserve() {
        if (seats.size() < 1) {
            return smallest++;
        }
        return seats.poll();
    }

    public void unreserve(int seatNumber) {
        this.seats.offer(seatNumber);
    }
}
