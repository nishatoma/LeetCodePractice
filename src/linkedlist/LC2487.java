package linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC2487 {
    public ListNode removeNodes(ListNode head) {
        // Reverse list, delete, and then reverse back
        ListNode tail = reverse(head);
        ListNode curr = tail;
        int max = curr.val;
        while (curr != null && curr.next != null) {
            if (curr.val > curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return reverse(tail);
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode removeNodesUsingStack(ListNode head) {
        // Use monotonically decreasing stack
        Deque<Integer> stack = new ArrayDeque<>();

        ListNode curr = head;
        while (curr != null) {
            while (!stack.isEmpty() && stack.peek() < curr.val) {
                stack.pop();
            }
            stack.push(curr.val);
            curr = curr.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        while (!stack.isEmpty()) {
            newHead.next = new ListNode(stack.pollLast());
            newHead = newHead.next;
        }
        return dummy.next;
    }
}
