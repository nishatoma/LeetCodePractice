package trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LC110 {
    public boolean isBalanced(TreeNode root) {
        // boolean[] balanced = new boolean[]{true};
        // Now try an iterative version (Post Order)
        if (root == null) return true;
        // Make a stack
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        // Make a refrence to current and last visited
        TreeNode curr = root;
        TreeNode lastVisited = null;
        // Make a mapping between a node and its height
        Map<TreeNode, Integer> nodeToHeight = new HashMap<>();
        // Iterate
        while (!stack.isEmpty() || curr != null) {
            // Much like in-order
            while (curr != null) {
                // push curr
                stack.push(curr);
                curr = curr.left;
            }
            // Now that we are out, peek out of the stack
            TreeNode node = stack.peek();
            // Check right side
            if (node.right != null && node.right != lastVisited) {
                // Make the curr = to that right node
                // And begin the process again
                curr = node.right;
            } else {
                // Otherwise, we can now process this node..
                // So, if we have a left child and right child for this node
                // Then we know we have processed this node before..
                int leftHeight = (node.left != null ? nodeToHeight.remove(node.left) : 0);
                int rightHeight = (node.right != null ? nodeToHeight.remove(node.right) : 0);
                // Now that we have the two heights, compare the diff
                if (Math.abs(leftHeight - rightHeight) > 1) return false;
                // Otherwise, we can pop the stack
                stack.pop();
                // Assign new height to current node
                nodeToHeight.put(node, Math.max(leftHeight, rightHeight) + 1);
                // Mark as visited
                lastVisited = node;
            }
        }
        return true;
    }

    private int getDepth(TreeNode root, int depth, boolean[] balanced) {
        if (root == null) return depth;
        // Get left and right first
        int leftDepth = getDepth(root.left, depth + 1, balanced);
        int rightDepth = getDepth(root.right, depth + 1, balanced);
        // Check Abs difference here between depths
        if (Math.abs(leftDepth - rightDepth) > 1) {
            balanced[0] = false;
        }

        return Math.max(leftDepth, rightDepth);
    }
}
