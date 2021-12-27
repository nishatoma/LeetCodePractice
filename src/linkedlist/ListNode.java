package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ListNode {

    private final int data;
    private ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(7);

        ListNode e = new ListNode(2);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(6);
        ListNode h = new ListNode(8);

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
        ListNode newNode = getReversedLinkedList(a);
//        printLinkedList(newNode);
        // print list a because wtf
        printLinkedList(newNode);
        printLinkedList(a);
        // Print merged list
        printLinkedList(zipperMergeTwoLists(a, e));
    }

    private static void printLinkedList(ListNode head) {

        if (head == null) {
            return;
        }

        ListNode current = head;

        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }

    private static void printLinkedListRecursively(ListNode head) {
        if (head == null) {
            return;
        }

        System.out.println(head.toString());
        printLinkedListRecursively(head.next);
    }

    // Given the head of the linked list,
    // return an array with all the values of that linked list
    private static int[] getArrayFormOfLinkedList(ListNode head){
        if (head == null) {
            return new int[0];
        }

        int[] result = new int[getCount(head)];

        ListNode current = head;
        int i = 0;
        while (current != null) {
            result[i] = current.data;
            i++;
            current = current.next;
        }
        return result;
    }

    private static List<Integer> getArrayListFormOfLinkedList(ListNode head) {
        if (head == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            result.add(curr.data);
            curr = curr.next;
        }

        return result;
    }

    private static int getCount(ListNode head) {
        if (head == null) {
            return 0;
        }

        ListNode curr = head;
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

    private static int getTotalSumOfLinkedList(ListNode head) {
        if (head == null) {
            return 0;
        }

        ListNode curr = head;
        int sum = 0;

        while (curr != null) {
            sum += curr.data;
            curr = curr.next;
        }

        return sum;
    }

    private static int getTotalSumOfLinkedListRecursively(ListNode head) {
        if (head == null) {
            return 0;
        }

        return head.data + getTotalSumOfLinkedListRecursively(head.next);
    }

    private static boolean doesNodeExist(ListNode head, int data) {
        if (head == null) {
            return false;
        }

        ListNode curr = head;

        while (curr != null) {
            if (curr.data == data) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    private static boolean doesNodeExistRecursively(ListNode head, int data) {
        if (head == null) {
            return false;
        }

        return doesNodeExistRecursively(head.next, data) || (head.data == data);
    }

    private static int getValueAtIndex(ListNode head, int position) {
        if (head == null || getCount(head) <= position) {
            return Integer.MIN_VALUE;
        }

        ListNode curr = head;
        int count = 0;

        while (count < position) {
            if (curr.next != null) {
                curr = curr.next;
            }
            count++;
        }

        return curr.data;
    }

    private static ListNode getReversedLinkedList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode curr = getListCopy(head);
        ListNode prev = null;

        // (1) -> (2) -> (3) -> (4)
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static ListNode zipperMergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return  null;
        }

        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        ListNode curr1 = head1;
        ListNode curr2 = head2;

        while (curr1 != null && curr2 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;

            // Now swap
            curr1.next = curr2;
            curr2.next = next1;

            // Now move up ahead
            curr1 = next1;
            curr2 = next2;
        }

        return head1;
    }

    private static ListNode getListCopy(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(head.data);
        ListNode newHeadCopy = newHead;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null) {
                newHead.next = new ListNode(curr.next.data);
                newHead = newHead.next;
            }
            curr = curr.next;
        }
        return newHeadCopy;
    }

    public ListNode getNext() {
        return next;
    }

    public int getData() {
        return data;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node {" +
                "data = " + data + " }";
    }
}
