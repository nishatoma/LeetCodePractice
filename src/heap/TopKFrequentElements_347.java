package heap;

import oop.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements_347 {
    public int[] topKFrequent(int[] nums, int k) {
        // Max Heap
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        // Result array
        int[] res = new int[k];
        // Hashmap to store num and it's freq
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            Pair<Integer, Integer> pair = new Pair<>(key, map.get(key));
            q.offer(pair);
            if (q.size() > k) {
                q.poll();
            }
        }
        while (k-- != 0) {
            res[k] = q.poll().getKey();
        }
        return res;
    }
}
