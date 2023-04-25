package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc682 {
    public int calPoints(String[] operations) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String str : operations) {
            char c = str.charAt(0);
            if (c == '+') {
                int pop = stack.pop();
                int peek = stack.peek();
                stack.push(pop);
                stack.push(peek + pop);
                res += peek + pop;
            } else if (c == 'D') {
                stack.push(stack.peek() * 2);
                res += stack.peek();
            } else if (c == 'C') {
                res -= stack.pop();
            } else {
                int push = Integer.parseInt(str);
                stack.push(push);
                res += push;
            }
        }

        return res;
    }
}
