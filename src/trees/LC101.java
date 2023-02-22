package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LC101 {
    public boolean isSymmetric(TreeNode root) {
        // Check null
        if (root == null) return true;
        // We can also do this iterative
        // Using BFS this time
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        // check empty
        while (!queue.isEmpty()) {
            // get both elements
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            // Check both values
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            // Check val
            if (n1.val != n2.val) return false;
            // Offer the rest
            // order matters
            queue.offer(n1.right);
            queue.offer(n2.left);
            queue.offer(n1.left);
            queue.offer(n2.right);
        }
        return true;
    }

    // public boolean isSymmetric(TreeNode root) {
    //     // We can also do this iterative
    //     // Remember a stack class can hold null
    //     Stack<TreeNode> stack = new Stack<>();
    //     stack.push(root.left);
    //     stack.push(root.right);
    //     // Iterate
    //     while (!stack.isEmpty()) {
    //         // Get the two nodes
    //         TreeNode nodeA = stack.pop();
    //         TreeNode nodeB = stack.pop();
    //         // If both are null, just continue
    //         if (nodeA == null && nodeB == null) continue;
    //         // Check if either are null
    //         if (nodeA == null || nodeB == null || nodeA.val != nodeB.val) return false;
    //         // Push left and right children
    //         stack.push(nodeA.right);
    //         stack.push(nodeB.left);
    //         stack.push(nodeA.left);
    //         stack.push(nodeB.right);
    //     }
    //     return true;
    // }

    private boolean dfs(TreeNode right, TreeNode left) {
        if (right == null || left == null) {
            return right == left;
        }
        if (right.val != left.val) return false;
        // Compare children now
        return dfs(right.left, left.right) && dfs(right.right, left.left);
    }
}
