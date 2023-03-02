package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC933 {
    class RecentCounter {

        Deque<Integer> q;

        public RecentCounter() {
            q = new ArrayDeque<>();
        }

        public int ping(int t) {
            q.offer(t);
            while (q.peek() < t - 3000) {
                q.poll();
            }
            return q.size();
        }
    }
}
