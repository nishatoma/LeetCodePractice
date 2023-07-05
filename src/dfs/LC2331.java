package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC2331 {
    public boolean evaluateTree(TreeNode root) {
        // return dfs(root);
        // Can also use pre-order traversal
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val > 1) {
                if (node.left.val > 1 || node.right.val > 1) {
                    stack.push(node);
                    if (node.left.val > 1) {
                        stack.push(node.left);
                    }
                    if (node.right.val > 1) {
                        stack.push(node.right);
                    }
                } else {
                    node.val = (node.val == 2) ? node.left.val | node.right.val : node.left.val & node.right.val;
                }
            }
        }

        return root.val != 0;
    }

    private boolean dfs(TreeNode root) {
        switch (root.val) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return dfs(root.left) || dfs(root.right);
            case 3:
                return dfs(root.left) && dfs(root.right);
            default:
                return false;
        }
    }
}
