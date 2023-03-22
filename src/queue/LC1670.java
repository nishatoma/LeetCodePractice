package queue;

public class LC1670 {
    ListNode head;
    ListNode tail;
    ListNode mid;
    int size;

    public LC1670() {
        this.head = new ListNode(0);
        this.tail = new ListNode(0);
        this.mid = null;
        this.head.next = tail;
        this.tail.prev = head;
        this.size = 0;
    }

    public void pushFront(int val) {
        ListNode newNode = new ListNode(val);
        this.head.next.prev = newNode;
        newNode.next = this.head.next;
        this.head.next = newNode;
        newNode.prev = this.head;
        ++this.size;
        if (this.size == 1) {
            this.mid = newNode;
        } else if (this.size % 2 == 0) {
            this.mid = mid.prev;
        }
    }

    public void pushMiddle(int val) {
        ListNode newNode = new ListNode(val);
        if (this.size == 0) {
            pushFront(val);
        } else {
            if (this.size % 2 == 0) {
                pushAfterMid(newNode);
            } else {
                pushBeforeMid(newNode);
            }
        }
    }

    public void pushBack(int val) {
        ListNode newNode = new ListNode(val);
        this.tail.prev.next = newNode;
        newNode.prev = this.tail.prev;
        this.tail.prev = newNode;
        newNode.next = this.tail;
        ++this.size;
        if (this.size == 1) {
            this.mid = newNode;
        } else if (this.size % 2 == 1) {
            this.mid = mid.next;
        }
    }

    public int popFront() {
        if (this.size < 1) {
            return -1;
        }
        ListNode node = this.head.next;
        removeNode(node);
        --this.size;
        if (this.size % 2 != 0) {
            this.mid = this.mid.next;
        }
        return node.val;
    }

    public int popMiddle() {
        if (this.size < 1) {
            return -1;
        }
        int res = this.mid.val;
        removeNode(this.mid);
        --this.size;
        if (this.size % 2 == 0) {
            this.mid = this.mid.prev;
        } else {
            this.mid = this.mid.next;
        }
        return res;
    }

    public int popBack() {
        if (this.size < 1) {
            return -1;
        }
        ListNode node = this.tail.prev;
        removeNode(node);
        --this.size;
        if (this.size % 2 == 0) {
            this.mid = this.mid.prev;
        }
        return node.val;
    }

    // Helper methods
    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void pushAfterMid(ListNode node) {
        node.next = this.mid.next;
        node.next.prev = node;
        node.prev = this.mid;
        this.mid.next = node;
        ++this.size;
        this.mid = node;
    }

    private void pushBeforeMid(ListNode node) {
        node.next = this.mid;
        node.prev = this.mid.prev;
        this.mid.prev = node;
        node.prev.next = node;
        ++this.size;
        this.mid = node;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode mid;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
