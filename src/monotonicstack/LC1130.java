package monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1130 {
    public int mctFromLeafValues(int[] arr) {
        int res = 0;
        if (arr == null || arr.length == 0) {
            return res;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : arr) {
            // Maintain decreasing stack
            while (!stack.isEmpty() && stack.peek() <= num) {
                int mid = stack.pop();
                if (stack.isEmpty()) {
                    res += mid * num;
                } else {
                    res += mid * Math.min(num, stack.peek());
                }
            }

            stack.push(num);
        }

        while (stack.size() > 1) {
            res += stack.pop() * stack.peek();
        }

        return res;
    }
}
