package linkedlist;

public class LC2181 {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        ListNode node = head;
        while (node != null) {
            if (node.getData() != 0) {
                ListNode newNode = new ListNode(0);
                while (node != null && node.getData() != 0) {
                    newNode.setData(newNode.getData() + node.getData());
                    node = node.getNext();
                }
                curr.setNext(newNode);
                curr = newNode;
            } else {
                node = node.getNext();
            }
        }
        return dummy.getNext();
    }
}
