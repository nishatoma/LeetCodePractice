package monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1944 {
    public int[] canSeePersonsCount(int[] heights) {
        // This is like next greater element II,
        // Similar idea, and we just simply go backward from the
        // array maintaining a monotonic decreasing stack.
        Deque<Integer> stack = new ArrayDeque<>();
        // // can use heights here for result
        // Iterate
        for (int i = heights.length - 1; i >= 0; --i) {
            // Make a count variable for the number of
            // elements this current element can see...
            int count = 0;
            // Get current height
            int h = heights[i];
            // Iterate throug hte stack if we have a new element
            // that is bigger than our stack peek to maintain monotonically
            // decreasing stack
            while (!stack.isEmpty() && stack.peek() < h) {
                // Pop
                stack.pop();
                ++count;
            }
            // Check if stack is empty, this is for cases where
            // the element never popped any thing from stack, but obviously
            // it should be still able to see its next neighbour..
            if (stack.size() > 0) {
                ++count;
            }
            // Make the current height equal to count
            heights[i] = count;
            // Push next element
            stack.push(h);
        }
        return heights;
    }
}
