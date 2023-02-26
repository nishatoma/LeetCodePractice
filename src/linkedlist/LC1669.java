package linkedlist;

public class LC1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode first = list1;

        for (int i = 0; i < a - 1; ++i) {
            first = first.next;
        }

        ListNode second = first;
        for (int i = 0; i <= b - (a - 1); ++i) {
            second = second.next;
        }

        ListNode last = list2;
        while (last != null && last.next != null) {
            last = last.next;
        }

        first.next = list2;
        last.next = second;
        return list1;
    }
}
