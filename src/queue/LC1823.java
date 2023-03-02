package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1823 {
    // Attempt of using constant
    // Space and Linear Runtime
    public int findTheWinner(int n, int k) {
        return findTheWinnerUsingQueue(n, k);
    }

    // Time Complexity: O(N * K)
    // Space Complexity: O(N)
    public int findTheWinnerUsingQueue(int n, int k) {
        // Make a queue
        // the idea is to store the
        // friends in a queue and start
        // polling up to k friends, then
        // re-queue if k != 0
        // in the end, if the size of the queue is 1
        // just return that element!
        Deque<Integer> q = new ArrayDeque<>();
        // Add each friend
        for (int i = 1; i <= n; ++i) {
            q.offer(i);
        }
        // Loop through
        int max = k;
        while (q.size() > 1) {
            int curr = q.poll();
            if (--max != 0) {
                q.offer(curr);
            } else {
                // We keep this friend kicked out
                max = k;
            }
        }
        return q.peek();
    }
}
