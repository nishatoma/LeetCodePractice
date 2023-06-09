package recursion;

import linkedlist.ListNode;

public class LC143 {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Slow is at middle
        // 5 -> 4
        fast = reverse(slow.next);
        // 1 -> 2 -> 3
        System.out.println(slow.val);
        slow.next = null;

        while (fast != null && head != null) {
            ListNode n1 = head.next;
            ListNode n2 = fast.next;
            head.next = fast;
            fast.next = n1;
            head = n1;
            fast = n2;
        }

    }

    private ListNode reverse(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
