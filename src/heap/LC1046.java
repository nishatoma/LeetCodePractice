package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC1046 {
    public int lastStoneWeight(int[] stones) {
        // Use priority queue,
        // Use max priority queue and pop top 2 elements then push back difference
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int sec = pq.poll();
            pq.offer(first - sec);
        }
        return pq.peek();
    }
}
