package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1614 {
    public int maxDepth(String s) {
        if (s == null || s.length() <= 1) return 0;
        // We can just use a count
        // instead of stack size!
        int max = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++count;
            } else if (c == ')') {
                --count;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public int maxDepthUsingStack(String s) {
        if (s == null || s.length() <= 1) return 0;
        int max = 0;

        // Get a stack
        Deque<Character> stack = new ArrayDeque<>();
        // For each character
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                max = Math.max(max, stack.size());
            } else if (c == ')') {
                stack.pop();
            }
        }
        return max;
    }
}
