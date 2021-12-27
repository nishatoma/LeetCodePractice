package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private final int data;
    private Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    public static void main(String[] args) {

        Node a = new Node(1);
        Node b = new Node(3);
        Node c = new Node(5);
        Node d = new Node(7);

        Node e = new Node(2);
        Node f = new Node(4);
        Node g = new Node(6);
        Node h = new Node(8);

        // a -> b -> c -> d -> null
        a.next = b;
        b.next = c;
        c.next = d;

        // e -> f -> g -> h -> null
        e.next = f;
        f.next = g;
        g.next = h;

        // Iterate through every node
//        printLinkedList(a);
//        printLinkedListRecursively(a);
//        // Get array form
//        int[] arr = getArrayFormOfLinkedList(a);
//        // print it
//        printArray(arr);
//        // Get Array List form
//        List<Integer> list = getArrayListFormOfLinkedList(a);
//        // print it
//        System.out.println();
//        System.out.println(list);
//        // Get total sum
//        System.out.println("Total sum: " + getTotalSumOfLinkedList(a));
//        // Get total sum recursively
//        System.out.println("Recursive sum: " + getTotalSumOfLinkedListRecursively(a));
//
//        // Does number 4 exist?
//        System.out.println(doesNodeExist(a, 4));
//        // Does # 5 exist?
//        System.out.println(doesNodeExist(a, 5));
//        // Does number 4 exist?
//        System.out.println(doesNodeExistRecursively(a, 4));
//        // Does # 5 exist?
//        System.out.println(doesNodeExistRecursively(a, 5));
//        // Get value at index 4
//        System.out.println("Value at index 4 (greater or equal to # of elements): " + getValueAtIndex(a, 4));
//        // Get value at index 3
//        System.out.println("Value at index 3: " + getValueAtIndex(a, 3));
        // Get Reversed Linked List
//        printLinkedList(getReversedLinkedList(a));
//        printLinkedList(getReversedLinkedList(a));
        Node newNode = getReversedLinkedList(a);
//        printLinkedList(newNode);
        // print list a because wtf
        printLinkedList(newNode);
        printLinkedList(a);
        // Print merged list
        printLinkedList(zipperMergeTwoLists(a, e));
    }

    private static void printLinkedList(Node head) {

        if (head == null) {
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }

    private static void printLinkedListRecursively(Node head) {
        if (head == null) {
            return;
        }

        System.out.println(head.toString());
        printLinkedListRecursively(head.next);
    }

    // Given the head of the linked list,
    // return an array with all the values of that linked list
    private static int[] getArrayFormOfLinkedList(Node head){
        if (head == null) {
            return new int[0];
        }

        int[] result = new int[getCount(head)];

        Node current = head;
        int i = 0;
        while (current != null) {
            result[i] = current.data;
            i++;
            current = current.next;
        }
        return result;
    }

    private static List<Integer> getArrayListFormOfLinkedList(Node head) {
        if (head == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Node curr = head;

        while (curr != null) {
            result.add(curr.data);
            curr = curr.next;
        }

        return result;
    }

    private static int getCount(Node head) {
        if (head == null) {
            return 0;
        }

        Node curr = head;
        int result = 0;

        while (curr != null) {
            result++;
            curr = curr.next;
        }

        return result;
    }

    private static void printArray(int[] arr) {
        if (arr.length == 0) {
            System.out.println("[]");
        }
        System.out.print("[");

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print("]");
    }

    private static int getTotalSumOfLinkedList(Node head) {
        if (head == null) {
            return 0;
        }

        Node curr = head;
        int sum = 0;

        while (curr != null) {
            sum += curr.data;
            curr = curr.next;
        }

        return sum;
    }

    private static int getTotalSumOfLinkedListRecursively(Node head) {
        if (head == null) {
            return 0;
        }

        return head.data + getTotalSumOfLinkedListRecursively(head.next);
    }

    private static boolean doesNodeExist(Node head, int data) {
        if (head == null) {
            return false;
        }

        Node curr = head;

        while (curr != null) {
            if (curr.data == data) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    private static boolean doesNodeExistRecursively(Node head, int data) {
        if (head == null) {
            return false;
        }

        return doesNodeExistRecursively(head.next, data) || (head.data == data);
    }

    private static int getValueAtIndex(Node head, int position) {
        if (head == null || getCount(head) <= position) {
            return Integer.MIN_VALUE;
        }

        Node curr = head;
        int count = 0;

        while (count < position) {
            if (curr.next != null) {
                curr = curr.next;
            }
            count++;
        }

        return curr.data;
    }

    private static Node getReversedLinkedList(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = getListCopy(head);
        Node prev = null;

        // (1) -> (2) -> (3) -> (4)
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static Node zipperMergeTwoLists(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return  null;
        }

        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        Node curr1 = head1;
        Node curr2 = head2;

        while (curr1 != null && curr2 != null) {
            Node next1 = curr1.next;
            Node next2 = curr2.next;

            // Now swap
            curr1.next = curr2;
            curr2.next = next1;

            // Now move up ahead
            curr1 = next1;
            curr2 = next2;
        }

        return head1;
    }

    private static Node getListCopy(Node head) {
        if (head == null) {
            return null;
        }

        Node newHead = new Node(head.data);
        Node newHeadCopy = newHead;
        Node curr = head;

        while (curr != null) {
            if (curr.next != null) {
                newHead.next = new Node(curr.next.data);
                newHead = newHead.next;
            }
            curr = curr.next;
        }
        return newHeadCopy;
    }

    public Node getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Node {" +
                "data = " + data + " }";
    }
}
