package recursion;

import linkedlist.ListNode;

public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Step 1: Find if we even have k elements left
        ListNode node = head;
        int count = 0;
        while (count < k) {
            if (node == null) {
                return head;
            }
            node = node.next;
            ++count;
        }

        // Step 2: Reverse k group
        ListNode pre = reverseKGroup(node, k);
        while (count-- != 0) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}
