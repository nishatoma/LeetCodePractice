package linkedlist;

public class LC1472 {
    class BrowserHistory {
        class ListNode {
            private String page;
            ListNode next;
            ListNode prev;

            public ListNode(String page, ListNode next, ListNode prev) {
                this.page = page;
                this.next = next;
                this.prev = prev;
            }

            public ListNode(String page) {
                this.page = page;
                this.next = null;
                this.prev = null;
            }
        }

        private ListNode curr;

        public BrowserHistory(String homepage) {
            this.curr = new ListNode(homepage);
        }

        public void visit(String url) {
            this.curr.next = new ListNode(url);
            this.curr.next.prev = this.curr;
            this.curr = this.curr.next;
        }

        public String back(int steps) {
            while (curr.prev != null && steps-- >= 1) {
                curr = curr.prev;
            }
            return this.curr.page;
        }

        public String forward(int steps) {
            while (curr.next != null && steps-- >= 1) {
                curr = curr.next;
            }
            return this.curr.page;
        }
    }
}
