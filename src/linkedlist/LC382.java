package linkedlist;

import java.util.Random;

public class LC382 {
    private ListNode head;
    private Random rng;

    public LC382(ListNode head) {
        this.head = head;
        rng = new Random();
    }

    public int getRandom() {
        ListNode res = null;
        ListNode curr = head;

        for (int i = 1; curr != null; ++i) {
            if (rng.nextInt(i) == i - 1) {
                res = curr;
            }
            curr = curr.next;
        }
        return res.val;
    }
}
