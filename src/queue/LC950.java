package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] res = new int[n];
        // Sort
        Arrays.sort(deck);
        // Fill the queue with indices of sorted array
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i){
            q.offer(i);
        }

        // Loop over again
        for (int i = 0; i < n; ++i) {
            res[q.poll()] = deck[i];
            // Move front of queue to back now
            if (!q.isEmpty())
                q.offer(q.poll());
        }

        return res;
    }
}
