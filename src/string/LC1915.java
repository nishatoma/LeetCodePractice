package string;

import java.util.HashMap;
import java.util.Map;

public class LC1915 {
    public long wonderfulSubstrings(String word) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int mask = 0;
        long res = 0;

        for (int i = 0; i < word.length(); ++i) {
            mask = mask ^ (1 << (word.charAt(i) - 'a'));
            res += map.getOrDefault(mask, 0);
            map.put(mask, map.getOrDefault(mask, 0) + 1);

            // Then for each possible substring until i,
            // Try and see how many wonderful substrings there are
            for (int j = 0; j < 10; ++j) {
                res += map.getOrDefault(mask ^ (1 << j), 0);
            }
        }
        return res;
    }
}
