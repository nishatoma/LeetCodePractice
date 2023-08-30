package recursion;

import linkedlist.ListNode;

public class LC234 {
    ListNode node;

    public boolean isPalindrome(ListNode head) {
        return isPal(head);
    }

    private boolean isPal(ListNode head) {
        if (head == null) {
            return true;
        }
        if (node == null) {
            node = head;
        }

        boolean flag = isPal(head.next);

        if (head.val == node.val) {
            node = node.next;
        } else {
            flag = false;
        }
        return flag;
    }
}
