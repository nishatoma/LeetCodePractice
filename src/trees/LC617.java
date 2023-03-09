package trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        // Make a queue to traverse both trees at the same time
        Deque<TreeNode[]> q = new ArrayDeque<>();
        q.offer(new TreeNode[]{root1, root2});
        // Iterate
        while (!q.isEmpty()) {
            // Get current size
            int size = q.size();
            // Iterate
            while (size-- != 0) {
                // Get current arr
                TreeNode[] arr = q.poll();

                // update val
                if (arr[1] == null) {
                    // No need to do anything
                    continue;
                }
                // Otherwise increase root1 value
                arr[0].val = (int) arr[0].val + (int) arr[1].val;
                // check if the left child of
                // root1 is null, if so, just use root2 since it's not null
                if (arr[0].left == null) {
                    // Then in next iteration we can add to queue!
                    arr[0].left = arr[1].left;
                } else {
                    // Otherwise just add both to queue
                    q.offer(new TreeNode[]{arr[0].left, arr[1].left});
                }
                // Same here with right child
                if (arr[0].right == null) {
                    arr[0].right = arr[1].right;
                } else {
                    q.offer(new TreeNode[]{arr[0].right, arr[1].right});
                }
            }
        }
        // Return root1
        return root1;
    }
}
