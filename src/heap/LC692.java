package heap;

import java.util.*;

public class LC692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList<>();

        Map<String, Integer> map = new HashMap<>();

        // Get words and their freq, O(N)
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Fill the priority queue.
        PriorityQueue<Word> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (String key : map.keySet()) {
            pq.offer(new Word(key, map.get(key)));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Add to our result
        while (!pq.isEmpty()) {
            res.add(0, pq.poll().value);
        }
        return res;
    }

    class Word implements Comparable<Word> {

        int freq;
        String value;

        public Word(String value, int freq) {
            this.value = value;
            this.freq = freq;
        }

        @Override
        public int compareTo(Word other) {
            if (this.freq == other.freq) {
                return this.value.compareTo(other.value); // Sort lexicographically when frequencies are equal
            }
            return other.freq - this.freq; // Sort by frequency in descending order
        }

    }
}
