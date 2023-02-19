package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC1876 {
    public int countGoodSubstrings(String s) {
        // The easy one is easy, what about generalized k?
        // Make a map in that case
        Map<Character, Integer> map = new HashMap<>();
        // Make a res variable
        int res = 0;
        // Make a case for number of duplicates
        int dup = 0;
        // get our 'k'
        int k = 3;
        // Iterate
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            // Get the character
            char c = s.charAt(i);
            // Add to map
            map.put(c, map.getOrDefault(c, 0) + 1);
            // Check the limit
            if (map.get(c) == 2) {
                // We passed the limit, increase dup..
                dup++;
            }
            // if our window is less than k, just continue
            if (i < k - 1) continue;
            // check dup version
            if (dup == 0) {
                // Then add to result
                ++res;
            }
            // decrease map count of left size..
            map.put(s.charAt(i - (k - 1)), map.getOrDefault(s.charAt(i - (k - 1)), 0) - 1);
            // Check the count of that left side, if it is 1, then it was two before,
            // So then decrease dup...
            if (map.get(s.charAt(i - (k - 1))) == 1) --dup;
        }
        return res;
    }
}
