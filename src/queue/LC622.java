package queue;

public class LC622 {
    int maxSize;
    int currSize;
    Node head;
    Node tail;

    public LC622(int k) {
        this.maxSize = k;
        this.currSize = 0;
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.tail.prev = this.head;
        this.head.next = this.tail;
        this.head.prev = null;
        this.tail.next = null;
    }

    public boolean enQueue(int value) {
        if (currSize == maxSize) {
            return false;
        }
        Node newNode = new Node(value);
        newNode.prev = this.tail.prev;
        newNode.next = this.tail;
        newNode.prev.next = newNode;
        this.tail.prev = newNode;
        ++this.currSize;
        return true;
    }

    public boolean deQueue() {
        if (this.currSize == 0) {
            return false;
        }
        // Front
        Node front = this.head.next;
        this.head.next = front.next;
        front.next.prev = this.head;
        --this.currSize;
        return true;
    }

    public int Front() {
        if (this.currSize == 0) {
            return -1;
        }
        return this.head.next.val;
    }

    public int Rear() {
        if (this.currSize == 0) {
            return -1;
        }
        return this.tail.prev.val;
    }

    public boolean isEmpty() {
        return (this.currSize == 0);
    }

    public boolean isFull() {
        return (this.currSize == this.maxSize);
    }

    class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
}
