package monotonicstack;

import linkedlist.ListNode;

public class LC2487 {
    public ListNode removeNodes(ListNode head) {

        // 1) Reverse the list
        ListNode reversed = reverse(head);

        ListNode curr = reversed;
        // 2) Iterate
        while (curr != null) {
            // 3) For each next, compare value with current
            // and remove from reference if smaller
            while (curr.next != null && curr.next.val < curr.val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        // 4) Reverse back to original list..
        return reverse(reversed);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
