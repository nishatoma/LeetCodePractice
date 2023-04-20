package monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC739 {
    public int[] dailyTemperatures(int[] temps) {
        // Use Increasing stack this time and keep index in the stack
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temps.length;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
                // pop
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }
}
