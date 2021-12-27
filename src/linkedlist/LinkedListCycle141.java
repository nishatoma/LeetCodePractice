package linkedlist;

public class LinkedListCycle141 {
    public boolean hasCycle(Node head) {

        Node fastPointer = head;
        Node slowPointer = head;

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