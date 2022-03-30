package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets904 {

    public int totalFruit(int[] fruits) {
        int max = Integer.MIN_VALUE;

        // To keep track of seen fruit before
        Map<Integer, Integer> map = new HashMap<>();
        // Left side of our window
        int l = 0;
        // Basket limit, we can only have 2
        int maxBaskets = 2;

        for (int r = 0; r < fruits.length; ++r) {
            if (map.containsKey(fruits[r])) {
                map.put(fruits[r], map.get(fruits[r]) + 1);
            } else {
                map.put(fruits[r], 1);
            }

            // if we reach max baskets
            while (l < fruits.length && map.size() > maxBaskets) {
                // Decrement the number of fruits we can pick
                // from the left side
                map.put(fruits[l], map.get(fruits[l]) - 1);
                // If we ran out of fruits from one basket, simply
                // remove it from the seen map
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            // Update the result here
            // The size of our window is r - l + 1
            // because indices start at zero.
            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
