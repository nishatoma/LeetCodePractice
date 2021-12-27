package linkedlist;

public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {

        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (fastPointer != null && fastPointer.getNext() != null) {

            fastPointer = fastPointer.getNext().getNext();
            slowPointer = slowPointer.getNext();

            if (fastPointer == slowPointer) {
                return true;
            }
        }

        return false;

    }
}