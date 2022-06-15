package twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels_763 {

    public List<Integer> partitionLabels(String s) {
        // Make a hashmap to store index and character
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), i);
        }

        // Now see where each character ends,
        // if we reach an index where we encounter the character
        // with the biggest index, and it matches, then we partition
        int max = 0;
        int prev = -1;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < s.length(); ++i) {
            max = Math.max(max, map.get(s.charAt(i)));
            if (max == i) {
                res.add(max - prev);
                prev = max;
            }
        }
        return res;
    }
}
