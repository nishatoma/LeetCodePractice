package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizeToTheHalf_1338 {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        // What if we sort by count in hashmap, then use heap
        // To build our result set
        Map<Integer, Integer> map = new HashMap<>();
        // For each number, store occurence/frequency
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Make a priority queue to sort the frequencies by highest
        // Max PQ
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        // For all the keys
        for (int key : map.keySet()) {
            // Store the numbers with the biggest frequencies
            pq.add(map.get(key));
        }
        // Now iterate, and sum up the frequencies,
        // and see if the sum is >= n/2
        int sum = 0;
        int res = 0;
        while (!pq.isEmpty()) {
            // Add frequency to sum
            sum += pq.poll();
            // Increase set size
            res++;
            // check if sum greater >= n / 2
            if (sum >= n / 2) return res;
        }
        return res;
    }
}
