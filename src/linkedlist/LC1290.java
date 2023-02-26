package linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1290 {
    public int getDecimalValue(ListNode head) {
        int i = 0;
        ListNode curr = head;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        // Iterate again
        while (!stack.isEmpty()) {
            res += (stack.pop() * Math.pow(2, i++));
        }
        return res;
    }
}
