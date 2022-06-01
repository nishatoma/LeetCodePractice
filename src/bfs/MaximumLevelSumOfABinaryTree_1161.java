package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumLevelSumOfABinaryTree_1161 {

    public int maxLevelSum(TreeNode root) {
        int res = 0;
        int max = Integer.MIN_VALUE;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        // Keep track of current level
        int level = 0;
        // While we have nodes to process
        while (!q.isEmpty()) {
            // Keep track of current level nodes
            int n = q.size();
            // Keep track of current level sum
            int sum = 0;
            // increment level
            level++;
            // For all the nodes in this level
            while (n-- != 0) {
                TreeNode<Integer> curr = q.poll();
                // Add up the node value to the sum
                sum += curr.getVal();
                // add children nodes to q for processing
                if (curr.getLeft() != null) q.offer(curr.getLeft());
                if (curr.getRight() != null) q.offer(curr.getRight());
            }
            // Compare to global maxima
            if (sum > max) {
                max = sum;
                // assign the result level to the current global maximum sum
                res = level;
            }
        }
        return res;
    }
}
