package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        // track max
        int max = 0;
        // Map
        Map<Character, Integer> map = new HashMap<>();
        // Iterate
        // Keep a window size
        int l = 0;
        // keep length
        int len = s.length();
        for (int r = 0; r < len; ++r) {
            // store in map first
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            // check duplicates
            while (map.get(s.charAt(r)) > 1) {
                // We have a duplicate, decrease and move window
                map.put(s.charAt(l), map.get(s.charAt(l++)) - 1);
            }
            // take max
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
