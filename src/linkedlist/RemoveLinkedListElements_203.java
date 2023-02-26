package linkedlist;

public class RemoveLinkedListElements_203 {

    public ListNode removeElements(ListNode head, int val) {

        while ((head != null) && (head.getVal() == val)) {
            head = head.getNext();
        }

        ListNode curr = head;

        while (curr != null && curr.getNext() != null) {
            if (curr.getNext().getVal() == val) {
                curr.setNext(curr.getNext().getNext());
            } else {
                curr = curr.getNext();
            }

        }
        return head;
    }
}
