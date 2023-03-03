package string;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC32 {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        // Idea is that everytime we see a ")"
        // We pop the last index of the last seen "("
        int max = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                max = Math.max(max, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return max;
    }
}
