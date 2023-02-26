package twopointers;

import linkedlist.ListNode;

public class SwappingNodesInALinkedList_1721 {
    public ListNode swapNodes(ListNode head, int k) {
        // Get the number of elements first
        int i = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.getNext();
            i++;
        }
        // i is now at the end (= 5 for 5 elements)
        int r = i - k; // this will give us 5 - 2 + 1 = 4th element
        int l = k - 1; // this will give us 2nd element

        ListNode right = head;
        for (int j = 0; j < r; ++j) {
            right = right.getNext();
        }

        ListNode left = head;
        for (int j = 0; j < l; ++j) {
            left = left.getNext();
        }

        // Swap both left and right values
        int temp = left.getVal();
        left.setVal(right.getVal());
        right.setVal(temp);

        return head;
    }
}
