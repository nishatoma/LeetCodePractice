package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC1297 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int max = 0;
        int n = s.length();
        // Map to count # of freqs
        Map<String, Integer> map = new HashMap<>();
        // Iterate
        for (int i = 0; i < n - minSize + 1; ++i) {
            // Get substring
            String sub = s.substring(i, i + minSize);
            // Check if it's valid
            if (isValidFreq(sub, maxLetters)) {
                // Then we can potentially use this
                map.put(sub, map.getOrDefault(sub, 0) + 1);
                // update max
                max = Math.max(max, map.get(sub));
            }
        }

        return max;
    }

    private boolean isValidFreq(String substring, int maxLetters) {
        Set<Character> set = new HashSet<>();
        for (char c : substring.toCharArray()) {
            set.add(c);
        }
        return set.size() <= maxLetters;
    }
}
