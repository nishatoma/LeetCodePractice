package linkedlist;

public class MiddleOfTheLinkedList876 {

    public Node middleNode(Node head) {

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        return slow;

    }
}
