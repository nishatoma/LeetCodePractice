package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class SortAnArray_912 {
    // Time: O(n*log(n))
    public int[] sortArray(int[] nums) {
        // Use a priority queue, min or max, we use max
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        // For each number, add to queue
        for (int num : nums) q.offer(num);
        // Add to result array from queue popping
        int n = nums.length;
        // Make result array
        int[] res = new int[n];
        // For each number in queue
        while (n-- != 0) {
            res[n] = q.poll();
        }
        return res;
    }
}
