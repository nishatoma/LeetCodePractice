package trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC104 {
    // Try pre-order solution now
    public int maxDepth(TreeNode root) {
        // Let's try a DFS solution
        int res = 0;
        if (root == null) return res;
        // Make a stack
        Deque<Pair> stack = new ArrayDeque<>();
        // Now make a pair object
        Pair pair = new Pair(root, res);
        // Push the current pair, we are going to use pre-order traversal.
        stack.push(pair);
        // Now iterate
        while (!stack.isEmpty()) {
            // During the pre-order traversal,
            // We pop current element
            Pair curr = stack.pop();
            // Get current res
            int depth = curr.depth;
            // Compare with res
            res = Math.max(res, depth + 1);
            // Push children now.
            if (curr.node.right != null) stack.push(new Pair(curr.node.right, depth + 1));
            if (curr.node.left != null) stack.push(new Pair(curr.node.left, depth + 1));
        }
        return res;
    }

    // public int maxDepth(TreeNode root) {
    //     // Let's try a BFS solution first..
    //     int res = 0;
    //     if (root == null) return res;
    //     // Make a queue for BFS
    //     Deque<TreeNode> q = new ArrayDeque<>();
    //     q.offer(root);
    //     // Iterate
    //     while (!q.isEmpty()) {
    //         // get current size
    //         int size = q.size();
    //         // Iterate over current level
    //         while (size-- != 0) {
    //             // Get current element
    //             TreeNode curr = q.poll();
    //             // Offer the rest of the children
    //             if (curr.left != null) q.offer(curr.left);
    //             if (curr.right != null) q.offer(curr.right);
    //         }
    //         // After every level, increase res.
    //         res++;
    //     }
    //     return res;
    // }

    public class Pair {
        int depth;
        TreeNode node;

        public Pair(TreeNode node, int depth) {
            this.depth = depth;
            this.node = node;
        }
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) return depth;

        // get left side
        int left = dfs(root.left, depth + 1);
        int right = dfs(root.right, depth + 1);
        return Math.max(left, right);
    }
}
