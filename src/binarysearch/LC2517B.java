package binarysearch;

import java.util.Arrays;

public class LC2517B {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int minGap = 0;
        int maxGap = price[price.length - 1] - price[0];
        int ans = 0;

        while (minGap <= maxGap) {
            int midGap = minGap + (maxGap - minGap) / 2;
            if (maxTasteExists(price, midGap, k)) {
                ans = midGap;
                minGap = midGap + 1;
            } else {
                maxGap = midGap - 1;
            }
        }

        return ans;
    }

    private boolean maxTasteExists(int[] prices, int currentGap, int k) {
        int count = 1;
        int lastMin = prices[0];

        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] - lastMin >= currentGap) {
                ++count;
                if (count >= k) return true;
                lastMin = prices[i];
            }
        }
        return false;
    }
}
