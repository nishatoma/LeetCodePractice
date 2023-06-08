package binarysearch;

import trees.TreeNode;

public class LC222 {
    public int countNodes(TreeNode root) {
        int res = 0;


        int h = height(root);
        TreeNode curr = root;
        while (curr != null) {
            // Left and right subtree have same height.
            if (height(curr.right) == h - 1) {
                res += 1 << h;
                curr = curr.right;
            } else {
                res += 1 << (h - 1);
                curr = curr.left;
            }
            h--;
        }

        return res;
    }

    private int height(TreeNode node) {
        return node == null ? -1 : 1 + height(node.left);
    }
}
