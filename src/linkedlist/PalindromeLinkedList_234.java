package linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class PalindromeLinkedList_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }


        fast = head;
        slow = reversed(slow);

        while (slow != null) {
            if (slow.getData() != fast.getData()) {
                return false;
            }
            fast = fast.getNext();
            slow = slow.getNext();
        }


        return true;
    }

    public ListNode reversed(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode prev = null;

        while (head != null) {
            ListNode next = head.getNext();
            // Swap
            head.setNext(prev);
            prev = head;
            head = next;
        }

        return prev;
    }


}