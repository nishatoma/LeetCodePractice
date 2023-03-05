package twopointers;

import java.util.HashMap;
import java.util.Map;

public class LC76 {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        // Base case
        if (n > m) {
            return "";
        }
        // Make a map for String t
        Map<Character, Integer> map = new HashMap<>();
        // Store initial character count
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0, min = Integer.MAX_VALUE, r = 0, l = 0;
        int windowStart = -1;
        // Iterate over s and t
        while (r < m) {
            char c1 = s.charAt(r++);
            if (map.containsKey(c1)) {
                // Decrease freq of that char
                map.put(c1, map.get(c1) - 1);
                // Increase count only if the frequency is still positive
                if (map.get(c1) >= 0) {
                    ++count;
                }
            }
            // If our counter reaches n
            while (count == n) {
                // See if we can get a smaller window
                if (r - l < min) {
                    min = r - l;
                    windowStart = l;
                }
                // Update map freq again from left side
                char c2 = s.charAt(l++);
                if (map.containsKey(c2)) {
                    // Increase freq of c2 only if its freq in t is greater than 0
                    map.put(c2, map.get(c2) + 1);
                    if (map.get(c2) > 0) {
                        // Decrease count only if the freq of c2 in t is greater than 0
                        --count;
                    }
                }
            }
        }
        return windowStart == -1 ? "" : s.substring(windowStart, windowStart + min);
    }
}
