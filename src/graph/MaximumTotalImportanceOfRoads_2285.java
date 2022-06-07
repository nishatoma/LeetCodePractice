package graph;

import java.util.Arrays;

public class MaximumTotalImportanceOfRoads_2285 {

    public long maximumImportance(int n, int[][] roads) {
        // Count freq of each node
        int[] freqs = new int[n];
        // Long to store result
        long res = 0;
        // For each road, count their frequency
        for (int[] road : roads) {
            freqs[road[0]]++;
            freqs[road[1]]++;
        }
        // Sort roads by their freqs (imortance)
        Arrays.sort(freqs);
        // Go through the values from 1 to n
        for (int i = 0; i < n; ++i) {
            res += (i + 1L) * freqs[i];
        }
        return res;
    }
}
