package heap;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray_215 {
    public int findKthLargest(int[] nums, int k) {
        // Get a min queue
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        // Iterate through the numbers and add to queue
        for (int num : nums) {
            minQ.offer(num);
            // Get the Kth largest by
            // constantly deleting bigger than k amount of elements.
            if (minQ.size() > k) {
                minQ.poll();
            }
        }
        return minQ.poll();
    }
}
