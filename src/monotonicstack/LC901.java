package monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC901 {
    // Basic idea is to use an increasing mono stack of pairs of price + their span!!

    Deque<int[]> stack;

    public LC901() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        // cur result
        int span = 1;

        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            span += stack.peek()[1];
            stack.pop();
        }
        stack.push(new int[]{price, span});
        return span;
    }
}
