package recursion;

public class LC21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy;

        if (list1.val < list2.val) {
            dummy = new ListNode(list1.val);
            dummy.next = mergeTwoLists(list1.next, list2);
        } else {
            dummy = new ListNode(list2.val);
            dummy.next = mergeTwoLists(list1, list2.next);
        }
        return dummy;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
