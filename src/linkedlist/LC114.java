package linkedlist;

import trees.TreeNode;

public class LC114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // Get a current node
        TreeNode curr = root;
        // While curr is no null...
        while (curr != null) {
            // Check its left
            if (curr.left != null) {
                TreeNode left = curr.left;

                while (left.right != null) {
                    // Go to right most node
                    left = left.right;
                }

                // Make the right of right most node
                // the right sub-tree of current..
                left.right = curr.right;
                // update current's right
                curr.right = curr.left;
                // Update left
                curr.left = null;
            }
            // Update current.
            curr = curr.right;
        }
    }
}
