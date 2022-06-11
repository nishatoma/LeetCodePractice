package contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MatchSubstringAfterReplacement_2301 {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        // Create a mapping for mappings
        Map<Character, Set<Character>> map = new HashMap<>();
        // For each mapping, store their mapping
        for (char[] mapping : mappings) {
            map.computeIfAbsent(mapping[0], k -> new HashSet<>());
            // Then add the mapping
            map.get(mapping[0]).add(mapping[1]);
        }
        // After building the map, see if the sub is a possible sub-string
        // at each iteration of the original string
        for (int i = 0; i < s.length(); ++i) {
            if (isPossible(s, sub, map, i)) return true;
        }
        // Otherwise, return false after all that iteration
        return false;
    }

    private boolean isPossible(String s, String sub, Map<Character, Set<Character>> map, int i) {
        // Iterate over sub
        for (int j = 0; j < sub.length(); ++j) {
            // Edge case
            if (i >= s.length()) return false;
            if (sub.charAt(j) == s.charAt(i) || (map.containsKey(sub.charAt(j)) && map.get(sub.charAt(j)).contains(s.charAt(i)))) {
                // Simply advance over the rest of the string
                i++;
            } else {
                // otherwise it is not possible for this specific substring
                return false;
            }
        }
        return true;
    }
}
