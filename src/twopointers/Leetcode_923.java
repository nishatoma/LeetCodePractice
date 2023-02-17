package twopointers;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_923 {
    public int threeSumMulti(int[] arr, int target) {
        // Because duplicates are allowed, we use a map to store count
        Map<Integer, Integer> map = new HashMap<>();
        // Get mod
        int mod = (int) 1e9 + 7;
        long res = 0;
        // Store counts of each number
        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
        // Iterate through all nums
        for (int num1 : map.keySet()) {
            for (int num2 : map.keySet()) {
                // Get target result
                int num3 = target - num1 - num2;
                // If the map contains that num3, then we have a 3 scenarios
                if (map.containsKey(num3)) {
                    // Get count of all numbers
                    long c1 = map.get(num1);
                    long c2 = map.get(num2);
                    long c3 = map.get(num3);
                    // Scenario 1, all numbers are the same..
                    if (num1 == num2 && num2 == num3) {
                        // If all same, there is 1 way to choose essentially..
                        res += (c1 * (c1 - 1) * (c1 - 2)) / 6;
                    } else if (num1 == num2 && num2 != num3) {
                        // If only 2 nums are the same
                        res += (c1 * (c1 - 1) / 2) * c3;
                    } else if (num1 < num2 && num2 < num3) {
                        // All nums are different, just multiply their counts
                        res += (c1 * c2 * c3);
                    }
                    // Modulo res
                    res %= mod;
                }
            }
        }
        return (int) res;
    }
}
