package twopointers;

import java.util.HashMap;
import java.util.Map;

public class LC424 {
    public int characterReplacement(String s, int k) {
        int res = Integer.MIN_VALUE;
        int left = 0;
        int n = s.length();
        // The max frequency of a character seen so far
        int maxFreq = 0;
        // Map to keep track of counters..
        Map<Character, Integer> map = new HashMap<>();
        // Iterate
        for (int right = 0; right < n; ++right) {
            // Get current character
            char c = s.charAt(right);
            // Update character count
            map.put(c, map.getOrDefault(c, 0) + 1);
            // Update max requent character
            maxFreq = Math.max(maxFreq, map.get(c));
            // Check window size, if windowSize - maxFreq > k
            // Then we can't replace the characters anymore, so decrease
            // window size...
            if (right - left + 1 - maxFreq > k) {
                // Get character in the left and decrease its count
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                // Decrease window size
                ++left;
            }
            // Take max window size
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
