package heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC451 {
    public String frequencySort(String s) {
        // For each letter have a count
        Map<Character, Integer> map = new HashMap<>();
        // For each character, store the count
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // Construct a max heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        // For each element in the map, add its character and count
        for (Character key : map.keySet()) {
            pq.offer(new Pair(key, map.get(key)));
        }
        // Make a string builder
        StringBuilder sb = new StringBuilder();
        // For each member in priority queue
        while (!pq.isEmpty()) {
            // Get the current frequency
            // and count
            Pair curr = pq.poll();
            for (int i = 0; i < curr.count; ++i) {
                sb.append(curr.c);
            }
        }
        return sb.toString();
    }

    class Pair implements Comparable<Pair> {
        private Character c;
        private Integer count;

        public Pair(Character c, Integer count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.count, other.count);
        }
    }
}
