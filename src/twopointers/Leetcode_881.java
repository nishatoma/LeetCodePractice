package twopointers;

import java.util.Arrays;

public class Leetcode_881 {
    public int numRescueBoats(int[] people, int limit) {
        // so we do sort the array, but,
        // we take the minimum and maximum each time
        // if too big, just count one boat and move on to the
        // second largets, and if if fits, take both people
        // and increment both counters
        Arrays.sort(people);
        int len = people.length, left = 0, right = len - 1;
        int res = 0;
        while (left <= right) {
            // Get total weight
            int weight = people[left] + people[right];
            if (weight <= limit) {
                ++left;
            }
            --right;
            ++res;

        }
        return res;
    }
}
