package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumDepthOfBinaryTree_104 {

    public int maxDepth(TreeNode root) {
        // BFS Approach
        if (root == null) return 0;
        if (root.getLeft() == null && root.getRight() == null) return 1;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        // Keep track of levels
        int levels = 0;

        // Iterate all the nodes now
        while (!q.isEmpty()) {
            // Represents number of elements in current level
            int n = q.size();

            // Iterate over the nodes in the current level
            while (n-- != 0) {
                // Get recent element
                TreeNode curr = q.poll();

                // Add left and right children to queue
                if (curr.getLeft() != null) q.offer(curr.getLeft());
                if (curr.getRight() != null) q.offer(curr.getRight());
            }
            // We are done with this level, so increment 'levels'
            levels++;
        }
        return levels;
    }
}
