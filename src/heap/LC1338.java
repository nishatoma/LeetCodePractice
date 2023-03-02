package heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC1338 {
    public int minSetSize(int[] arr) {
        // Make a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // Make a map for freq count
        Map<Integer, Integer> map = new HashMap<>();
        // Iterate and store counts
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Iterate and store counts in PQ
        for (int value : map.values()) {
            pq.offer(value);
        }
        // int count for number of elements so far
        int count = 0;
        int res = 0;
        int n = arr.length / 2;
        // We will use the count to count # of elements
        // and if >= to n, then we can stop!
        // While queue is not empty
        while (!pq.isEmpty()) {
            // get the frequency
            int freq = pq.poll();
            // increment count and result
            ++res;
            count += freq;
            if (count >= n) break;
        }
        return res;
    }
}
