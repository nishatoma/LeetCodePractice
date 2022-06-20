package heap;

import oop.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency_451 {

    public String frequencySort(String s) {
        // Map to store freq/character
        Map<Character, Integer> map = new HashMap<>();
        // Visit each character, and add its frequency
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        // Sort the frequencies using a priority queue
        PriorityQueue<Pair<Character, Integer>> q = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        // Add to PQ
        for (char k : map.keySet()) {
            // The queue will have the character with the
            // highest frequency at the top
            q.offer(new Pair<Character, Integer>(k, map.get(k)));
        }
        // String builder for result
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Pair<Character, Integer> pair = q.poll();
            // Attach the letter freq amount of times
            int k = pair.getValue();
            while (k-- != 0) {
                sb.append(pair.getKey());
            }
        }
        return sb.toString();
    }
}
