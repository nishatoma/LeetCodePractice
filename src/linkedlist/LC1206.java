package linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class LC1206 {

    class Node {
        int val;
        Node next;
        Node down;

        public Node(int val, Node next, Node down) {
            this.val = val;
            this.next = next;
            this.down = down;
        }
    }

    Node head;
    Random random;

    public LC1206() {
        head = new Node(-1, null, null);
        random = new Random();
    }

    public boolean search(int target) {
        Node curr = head;
        while (curr != null) {
            while (curr.next != null && curr.next.val < target) {
                // Skip, hence skip list.
                // for example, 10 -> 20 -> 40 -> 50 -> 60
                // if we are looking for 60 we just keep skipping along.
                curr = curr.next;
            }
            if (curr.next != null && curr.next.val == target) return true;
            // Go down to the next level.
            curr = curr.down;
        }
        return false;
    }

    public void add(int num) {
        // Make a stack of nodes
        Deque<Node> stack = new ArrayDeque<>();
        // Top level head.
        Node curr = head;
        while (curr != null) {
            // We need to add in sorted order.
            while (curr.next != null && curr.next.val < num) {
                curr = curr.next;
            }
            // For example, if we adding 60
            // then we push 50 in 30 -> 50 -> 70
            stack.push(curr);
            // then move down in order to do the same thing in the next level.
            curr = curr.down;
        }
        // random chance whether to insert down to next level or not.
        // Essentially, we are now at the most bottom level with current....
        // And that's at the top of our stack.
        boolean insert = true;
        Node down = null;
        while (insert && !stack.isEmpty()) {
            // Again, this represents like our "50" at the current bottom level
            curr = stack.pop();
            // add
            curr.next = new Node(num, curr.next, down);
            // Update down
            down = curr.next;
            // coin toss
            insert = random.nextDouble() < 0.5;
        }
        // Push previous head to lower level.
        if (insert) head = new Node(-1, null, head);
    }

    public boolean erase(int num) {
        Node curr = head;
        boolean found = false;
        while (curr != null) {
            // skip
            while (curr.next != null && curr.next.val < num) {
                curr = curr.next;
            }
            if (curr.next != null && curr.next.val == num) {
                found = true;
                curr.next = curr.next.next;
            }
            // delete same element from lower levels.
            curr = curr.down;
        }
        return found;
    }
}
