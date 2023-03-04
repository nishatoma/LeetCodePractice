package string;

import java.util.HashMap;
import java.util.Map;

public class LC242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        // Go through each string
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // Go through second string
        for (int i = 0; i < n; ++i) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }

        return true;
    }
}
