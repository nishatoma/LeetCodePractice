package heap;

import java.util.PriorityQueue;

public class LastStoneWeight_1046 {
    public int lastStoneWeight(int[] stones) {
        // Init q
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        // Add all stones to q
        for (int stone : stones) q.offer(stone);
        // Start smashing stones
        while (q.size() > 1) {
            int s1 = q.poll();
            int s2 = q.poll();
            if (s1 != s2) {
                q.offer(s1 - s2);
            }
        }
        return !q.isEmpty() ? q.poll() : 0;
    }
}
