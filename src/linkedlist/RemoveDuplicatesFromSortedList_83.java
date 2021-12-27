package linkedlist;

public class RemoveDuplicatesFromSortedList_83 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        while (head != null && head.getNext() != null && head.getData() == head.getNext().getData()) {
            head = head.getNext();
        }

        ListNode curr = head;

        while (curr != null && curr.getNext() != null) {
            if (curr.getData() == curr.getNext().getData()) {
                curr.setNext(curr.getNext().getNext());
            } else {
                curr = curr.getNext();
            }
        }
        return head;
    }
}
