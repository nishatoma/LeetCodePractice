package linkedlist;

class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode temp = new ListNode(0);
        ListNode curr = temp;
        // Iterate through the two lists
        while (list1 != null && list2 != null) {
            if (list1.getVal() < list2.getVal()) {
                curr.setNext(list1);
                // Move to the next element in list 1.
                list1 = list1.getNext();
            } else {
                curr.setNext(list2);
                list2 = list2.getNext();
            }

            curr = curr.getNext();
        }
        // One of list1 or list2 might reach the null pointer faster
        if (list1 != null) {
            curr.setNext(list1);
        }

        if (list2 != null) {
            curr.setNext(list2);
        }

        return temp.getNext();
    }
}