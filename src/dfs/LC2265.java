package dfs;

import trees.TreeNode;

public class LC2265 {
    public int averageOfSubtree(TreeNode root) {
        Tuple tpl = dfs(root);
        return tpl.result();
    }

    private Tuple dfs(TreeNode root) {
        if (root == null) {
            return new Tuple(0, 0, 0);
        }


        Tuple left = dfs(root.left);
        Tuple right = dfs(root.right);

        // increase current sum for the root and add it to tuple later
        int sum = (int) root.val + left.sum() + right.sum();
        // Get the total amount of elements
        int total = 1 + left.totalElements() + right.totalElements();
        // Get the average
        int avg = sum / total;
        // Get count from left and right
        int res = left.result() + right.result();
        // Check for result
        if (avg == (int) root.val) {
            ++res;
        }
        return new Tuple(sum, total, res);
    }

    record Tuple(int sum, int totalElements, int result) {
    }
}
