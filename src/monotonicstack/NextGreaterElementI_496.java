package monotonicstack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        // Map numbers to their greatest elements
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate over second array to find greater elements
        for (int num : nums2) {
            // While the elements in the stack are smaller
            // than our current element, pop them and map them
            // to our greater element.
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Iterate over the array of nums1
        for (int i = 0; i < nums1.length; ++i) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
