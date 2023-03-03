package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC2558 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // store each num
        for (int gift : gifts) {
            pq.offer(gift);
        }

        while (k-- != 0) {
            int gift = pq.poll();
            gift = (int) Math.sqrt(gift);
            pq.offer(gift);
        }

        // At the end, add all of the gifts
        long res = 0;
        while (!pq.isEmpty()) {
            res += (long) pq.poll();
        }
        return res;
    }
}
