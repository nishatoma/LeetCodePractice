package linkedlist;

public class LC2130 {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = reverse(slow);
        fast = head;
        int res = 0;
        while (fast != null && mid != null) {
            res = Math.max(res, fast.val + mid.val);
            fast = fast.next;
            mid = mid.next;
        }
        return res;
    }

    private ListNode reverse(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
