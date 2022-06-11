package contest;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions_2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // Binary search solution
        int[] successPairs = new int[spells.length];
        // Sort potions array
        Arrays.sort(potions);
        // Go for each spell
        for (int i = 0; i < spells.length; ++i) {
            int countNot = 0;
            int lo = 0;
            int hi = potions.length;
            // Search in potions
            while (lo < hi) {
                int m = lo + (hi - lo) / 2;
                // If we have a successful potion, try the lower value
                // elements on the left side of the array
                if ((1L * spells[i]) * (1L * potions[m]) >= success) {
                    hi = m;
                } else {
                    // Otherwise, the potion was not successful,
                    // so we try an element at a higher index
                    lo = m + 1;
                }
            }
            // The number of successful pairs is the number of
            // total pairs - the unsuccessful ones, which lo index covers
            successPairs[i] = potions.length - lo;
        }
        return successPairs;
    }
}
