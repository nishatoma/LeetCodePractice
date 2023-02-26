package twopointers;

import linkedlist.ListNode;

public class MaximumTwinSumOfLinkedList_2130 {

    public int pairSum(ListNode head) {
        // 1) Identify middle of the list
        ListNode fast = head;
        ListNode slow = head;
        // Use the fast and slow pointers to reach the middle
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        // Identify node after slow
        fast = head;
        // Middle of our LinkedList will be at the slow pointer.
        // 2) reverse the first half of the list
        slow = reverse(slow);
        // Start from the very middle, slow pointer and it's next (rightHalf)
        // and iterate going both directions
        // keep a track of maximum sum
        int max = Integer.MIN_VALUE;
        while (slow != null) {
            max = Math.max(max, slow.getVal() + fast.getVal());
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return max;
    }

    public ListNode reverse(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode current = node;
        ListNode previous = null;
        while (current != null) {
            ListNode next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        return previous;
    }
}
