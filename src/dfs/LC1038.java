package dfs;

import trees.TreeNode;

public class LC1038 {
    public TreeNode bstToGst(TreeNode root) {
        dfs(root, 0);
        return root;
    }
    // idea is to go all the way to the right side
    // and keep track of a cumulative sum...
    private int dfs(TreeNode root, int totalSum) {
        // Base case
        if (root == null) {
            return totalSum;
        }
        // Otherwise,
        // Keep going right side
        int right = dfs(root.right, totalSum);
        // update root.val first
        root.val = (int) root.val + (int) right;
        // Update total Sum
        // Visit left side now
        int left = dfs(root.left, (int) root.val);
        return left;
    }
}
