package trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC700 {
    public TreeNode searchBST(TreeNode root, int val) {
        // We can use pre-order
        if ((int) root.val == val) return root;
        // Stack
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        // Iterate
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            // Compare
            if ((int) curr.val == val) {
                return curr;
            }
            // Check range
            if ((int) curr.val < val) {
                // Look right
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                // Try and look left
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }
        }
        // Last case
        return null;
    }

    public TreeNode searchBSTRecursively(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if ((int) root.val == val) {
            return root;
        }

        if ((int) root.val < val) {
            return searchBST(root.right, val);
        }
        return searchBST(root.left, val);
    }
}
