package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // BFS Solution
        Deque<TreeNode> q = new ArrayDeque<>();
        // push both clones and original
        q.offer(original);
        q.offer(cloned);
        // Iterate
        while (!q.isEmpty()) {
            // Get queue size
            int size = q.size();
            // Iterate over that level
            while (size-- > 0) {
                // Get current node
                TreeNode curr = q.poll();
                // Cloned curr
                TreeNode cloneCurr = q.poll();
                // Since we are getting the original node first
                // Compare it to target
                if (curr == target) {
                    // Then return the cloned one
                    return cloneCurr;
                }
                // Add the rest of the children here
                if (curr.left != null) {
                    q.offer(curr.left);
                    q.offer(cloneCurr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                    q.offer(cloneCurr.right);
                }
            }
        }
        return null;
    }
}
