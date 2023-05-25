package linkedlist;

import trees.TreeNode;

public class Lc109 {
    public TreeNode sortedListToBST(ListNode head) {
        // Basically, recursively find middle,
        // assign the left of middle as left of tree...
        // and right of middle as right and repeat
        if (head == null) {
            return null;
        }
        return toBst(head, null);
    }

    private TreeNode toBst(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode mid = new TreeNode(slow.val);

        mid.left = toBst(head, slow);
        mid.right = toBst(slow.next, tail);
        return mid;
    }
}
