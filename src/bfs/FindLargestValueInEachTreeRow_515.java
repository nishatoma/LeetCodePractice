package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FindLargestValueInEachTreeRow_515 {

    public List<Integer> largestValues(TreeNode root) {
        // Make a list of the result
        List<Integer> res = new ArrayList<>();
        // if no nodes
        if (root == null) return res;
        // Otherwise do a BFS
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        // Iterate BFS
        while (!q.isEmpty()) {
            int n = q.size();
            int max = Integer.MIN_VALUE;
            // Iterate over all nodes in given level
            while (n-- != 0) {
                TreeNode<Integer> curr = q.poll();
                // Update max
                max = Math.max(max, curr.getVal());
                // Iterate over the rest of the children
                if (curr.getLeft() != null) q.offer(curr.getLeft());
                if (curr.getRight() != null) q.offer(curr.getRight());
            }
            // Add max to result
            res.add(max);
        }
        return res;
    }
}
