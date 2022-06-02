package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindBottomLeftTreeValue_513 {

    public int findBottomLeftValue(TreeNode root) {
        // Initialise left-most leaf
        TreeNode<Integer> left = null;
        // Make a Q for BFS
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        //Iterate over q
        while (!q.isEmpty()) {
            // Get amount of nodes in current level
            int n = q.size();
            // Go from 0 to n, 0 representing left-most node!
            for (int i = 0; i < n; ++i) {
                // Get current node from q
                TreeNode curr = q.poll();
                // left-most node will always start from zero
                // for each level
                if (i == 0) left = curr;
                // Explore left and right children
                if (curr.getLeft() != null) q.offer(curr.getLeft());
                if (curr.getRight() != null) q.offer(curr.getRight());
            }
        }
        return left.getVal();
    }
}
