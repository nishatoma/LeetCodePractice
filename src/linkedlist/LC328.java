package linkedlist;

public class LC328 {
    public ListNode oddEvenList(ListNode head) {

        // Idea is to iterate both
        // odd and even pointers..
        if (head == null) {
            return head;
        }

        // Get an odd pointer
        ListNode odd = head;
        // Get an even pointer
        ListNode even = head.next;
        // Get the start of the even head
        // As we need to attach it later to the end of
        // the odd list
        ListNode evenHead = even;
        // Iterate
        while (even != null && even.next != null) {
            // Connect the odd ones
            odd.next = odd.next.next;
            // Connect the even ones
            even.next = even.next.next;
            // Change the odds
            odd = odd.next;
            // change even
            even = even.next;
        }
        // Attach the head of the even llist
        // to the end of the odd list
        odd.next = evenHead;
        // Return the head
        return head;
    }
}
