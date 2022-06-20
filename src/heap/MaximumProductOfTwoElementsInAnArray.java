package heap;

import java.util.PriorityQueue;

public class MaximumProductOfTwoElementsInAnArray {
    public int maxProduct(int[] nums) {
        // Max priority Queue
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int k = 2;
        // For each number
        for (int i = 0; i < nums.length; ++i) {
            // Add to Max Heap
            q.offer(nums[i] - 1);
            // Keep 2 elements at a time
            if (q.size() > k) {
                q.poll();
            }
        }
        // Return the product of the two largest numbers
        return (q.poll() * q.poll());
    }
}
