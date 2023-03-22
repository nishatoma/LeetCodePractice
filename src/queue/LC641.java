package queue;

public class LC641 {
    int size;
    int maxSize;
    ListNode head;
    ListNode tail;

    class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public LC641(int k) {
        this.maxSize = k;
        this.size = 0;
        this.head = new ListNode(-1);
        this.tail = new ListNode(-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        ListNode next = this.head.next;
        this.head.next = new ListNode(value);
        this.head.next.prev = head;
        this.head.next.next = next;
        this.head.next.next.prev = this.head.next;
        ++this.size;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        ListNode prev = this.tail.prev;
        ListNode newNode = new ListNode(value);
        this.tail.prev = newNode;
        this.tail.prev.next = tail;
        this.tail.prev.prev = prev;
        this.tail.prev.prev.next = this.tail.prev;
        ++this.size;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        ListNode curr = this.head.next;
        this.head.next = curr.next;
        curr.next.prev = this.head;
        --this.size;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        ListNode curr = this.tail.prev;
        this.tail.prev = curr.prev;
        curr.prev.next = this.tail;
        --this.size;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return this.head.val;
        }
        return this.head.next.val;
    }

    public int getRear() {
        if (isEmpty()) {
            return this.tail.val;
        }
        return this.tail.prev.val;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.maxSize;
    }
}
