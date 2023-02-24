package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // Base Case
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        // Queue for BFS
        Deque<TreeNode[]> q = new ArrayDeque<>();
        q.offer(new TreeNode[]{t1, t2});
        while (!q.isEmpty()) {
            TreeNode[] curr = q.poll();
            // Get both trees here
            TreeNode node1 = curr[0];
            TreeNode node2 = curr[1];
            // Check t2
            if (node2 == null) {
                continue;
            }
            // Add both t2 and t1 values
            node1.val = ((int) node2.val + (int) node1.val);
            // Process the rest here
            if (node1.left != null) {
                // push new nodes here
                q.offer(new TreeNode[]{node1.left, node2.left});
            } else {
                // Otherwise make node 1 node 2
                node1.left = node2.left;
            }
            if (node1.right != null) {
                // Same here
                q.offer(new TreeNode[]{node1.right, node2.right});
            } else {
                node1.right = node2.right;
            }
        }
        return t1;
    }
}
