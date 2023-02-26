package linkedlist;

public class LC2181 {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        ListNode node = head;
        while (node != null) {
            if (node.val != 0) {
                ListNode newNode = new ListNode(0);
                while (node != null && node.val != 0) {
                    newNode.val += node.val;
                    node = node.next;
                }
                curr.next = newNode;
                curr = newNode;
            } else {
                node = node.next;
            }
        }
        return dummy.next;
    }
}
