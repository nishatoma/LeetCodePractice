package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LC1721 {
    public ListNode swapNodes(ListNode head, int k) {
        // Another idea for O(1) one pass, is to simply start
        // another node from k and move next, and stop when
        // before the other nodes becomes null
        ListNode n1 = null, n2 = null;
        for (ListNode curr = head; curr != null; curr = curr.next) {
            n2 = n2 == null ? null : n2.next;
            if (--k == 0) {
                n1 = curr;
                n2 = head;
            }
        }
        // swap now
        int tmp = n2.val;
        n2.val = n1.val;
        n1.val = tmp;
        return head;
    }

    public ListNode swapNodesUsingList(ListNode head, int k) {
        // Another idea is to store the nodes in an array list in one pass
        // then swap the two elements..
        // Make a list
        List<ListNode> list = new ArrayList<>();
        // iterate and store elements in the list
        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        // Swap elements in constant time
        int tmp = list.get(k - 1).val;
        list.get(k - 1).val = list.get(list.size() - k).val;
        list.get(list.size() - k).val = tmp;
        return head;
    }

    public ListNode swapNodesCounting(ListNode head, int k) {
        // Another idea is to count the elements and use that to find indexes..
        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        ListNode a = head;

        for (int i = 1; i < k; ++i) {
            a = a.next;
        }

        ListNode b = head;

        for (int i = 0; i < (count - k); ++i) {
            b = b.next;
        }

        // Swap
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
        return head;
    }

    public ListNode swapWithReverse(ListNode head, int k) {
        ListNode a = head;

        for (int i = 1; i < k; ++i) {
            a = a.next;
        }

        ListNode tail = reverse(head);

        ListNode b = tail;

        for (int i = 1; i < k; ++i) {
            b = b.next;
        }

        int tmp = b.val;
        b.val = a.val;
        a.val = tmp;

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
}
