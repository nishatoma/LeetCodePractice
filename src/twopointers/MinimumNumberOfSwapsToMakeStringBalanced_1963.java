package twopointers;

public class MinimumNumberOfSwapsToMakeStringBalanced_1963 {
    public int minSwaps(String s) {
        int stackSize = 0;
        int n = s.length();
        // Basic idea, find all balanced paratheses.
        // get rid of balanced ones, count the number of unbalanced pairs
        // If we have n mismatchd pairs, then we have (n + 1) / 2 minimum swaps to do
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '[') {
                stackSize++;
            } else {
                if (stackSize > 0) {
                    stackSize--;
                }
            }
        }
        return (stackSize + 1) / 2;
    }
}
