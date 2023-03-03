package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC1753 {

    public int maximumScore(int a, int b, int c) {
        int score = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(a);
        pq.offer(b);
        pq.offer(c);

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            if (--first > 0) pq.offer(first);
            if (--second > 0) pq.offer(second);
            ++score;
        }
        return score;
    }
}
