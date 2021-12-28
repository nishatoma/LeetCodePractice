package linkedlist;

public class ReverseLinkedList_206 {

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.getNext();
            // Point current to previous
            curr.setNext(prev);
            // Set prev to current
            prev = curr;
            // move along the list
            curr = next;
        }
        // prev will be the new head of the list
        return prev;
    }
}
