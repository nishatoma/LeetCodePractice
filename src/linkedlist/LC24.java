package linkedlist;

public class LC24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }

        // dummy node
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode curr = newHead;

        // Tow nodes for temp iteration
        ListNode one = null;
        ListNode two = null;

        while (curr.next != null && curr.next.next != null) {
            // one and two
            one = curr.next;
            two = curr.next.next;
            one.next = two.next;
            two.next = one;
            curr.next = two;
            curr = one;
        }

        return newHead.next;
    }
}
