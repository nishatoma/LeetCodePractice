package recursion;

public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return dfs(l1, l2, 0);
    }


    private ListNode dfs(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;

        // get the sum
        int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
        // Get next
        l1 = l1 == null ? null : l1.next;
        l2 = l2 == null ? null : l2.next;
        // Get the next recursive function
        ListNode node = new ListNode(sum % 10, dfs(l1, l2, sum / 10));
        return node;
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
