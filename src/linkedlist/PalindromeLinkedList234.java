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
class PalindromeLinkedList234 {
    public boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;

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

    public Node reversed(Node head) {

        if (head == null) {
            return null;
        }

        Node prev = null;

        while (head != null) {
            Node next = head.getNext();
            // Swap
            head.setNext(prev);
            prev = head;
            head = next;
        }

        return prev;
    }


}