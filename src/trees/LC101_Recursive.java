package trees;

public class LC101_Recursive {
    public boolean isSymmetric(TreeNode root) {
        return root == null || dfs(root.right, root.left);
    }

    private boolean dfs(TreeNode right, TreeNode left) {
        if (right == null || left == null) {
            return right == left;
        }
        if (right.val != left.val) return false;
        // Compare children now
        return dfs(right.left, left.right) && dfs(right.right, left.left);
    }
}
