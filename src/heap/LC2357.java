package heap;

import java.util.PriorityQueue;

public class LC2357 {
    public int minimumOperations(int[] nums) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Add each non-zero element first
        for (int num : nums) {
            if (num != 0) {
                pq.offer(num);
            }
        }

        // Go through the queue
        // The idea is that if we see a current element
        // and subtract it with a previously seen
        // element, and the result is not zero, then we
        // increment the # of operations needed
        int count = 0, prev = 0;
        while (!pq.isEmpty()) {
            // get current elements
            int top = pq.poll();
            // Make an operation
            top = top - prev;
            // If the operation already resulted
            // in a zero, then skip, no need to add it
            // to the # of operations needed
            if (top <= 0) continue;
            // Otherwise, update our previous number
            prev += top;
            // And increment th result
            ++count;
        }
        return count;
    }
}
