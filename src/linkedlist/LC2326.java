package linkedlist;

public class LC2326 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        // define the 4 boundaries
        int top = 0;
        int left = 0;
        int right = n - 1;
        int bot = m - 1;
        // make current node head
        ListNode curr = head;

        while (top <= bot && left <= right) {
            // start from top first
            for (int j = left; j <= right; ++j) {
                fill(curr, top, j, res);
                if(curr != null) curr = curr.next;
            }
            // go down row for top
            top++;
            if (top > bot) break;
            // now go down
            for (int i = top; i <= bot; ++i) {
                fill(curr, i, right, res);
                if(curr != null) curr = curr.next;
            }
            // decrease right
            right--;
            if (right < left) break;
            // Now go left
            for (int j = right; j >= left; --j) {
                fill(curr, bot, j, res);
                if(curr != null) curr = curr.next;
            }
            // decrease bot
            bot--;
            if (top > bot) break;
            // Now go up
            for (int i = bot; i >= top; --i) {
                fill(curr, i, left, res);
                if(curr != null) curr = curr.next;
            }
            // increase left
            ++left;
            if (right < left) break;
        }
        return res;
    }

    void fill(ListNode curr, int i, int j, int[][] res) {
        if (curr != null) {
            res[i][j] = curr.val;
        } else {
            res[i][j] = -1;
        }
    }
}
