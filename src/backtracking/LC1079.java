package backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1079 {
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        // iterate over the array
        for (char c : tiles.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // We can also use a memo store results
        Map<Integer, Integer> memo = new HashMap<>();
        return backtrack(map, memo);
    }

    private int backtrack(Map<Character, Integer> map, Map<Integer, Integer> memo) {
        int sum = 0;
        // try this key
        int hash = Arrays.hashCode(map.values().toArray());
        if (memo.containsKey(hash)) return memo.get(hash);
        // Go through each key
        for (char key : map.keySet()) {
            // Check the count
            if (map.get(key) == 0) continue;
            // Decrement the count
            map.put(key, map.get(key) - 1);
            // dfs
            sum += 1 + backtrack(map, memo);
            map.put(key, map.get(key) + 1);
        }
        memo.put(hash, sum);
        return sum;
    }
}
