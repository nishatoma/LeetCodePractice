package linkedlist;

public class RemoveLinkedListElements203 {

    public ListNode removeElements(ListNode head, int val) {

        while ((head != null) && (head.getData() == val)) {
            head = head.getNext();
        }

        ListNode curr = head;

        while (curr != null && curr.getNext() != null) {
            if (curr.getNext().getData() == val) {
                curr.setNext(curr.getNext().getNext());
            } else {
                curr = curr.getNext();
            }

        }
        return head;
    }
}
