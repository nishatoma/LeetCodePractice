package dfs;

import trees.TreeNode;

public class DeepestLeavesSum_1302 {

    private int sum;
    private int maxLevel;

    public int deepestLeavesSum(TreeNode<Integer> root) {
        if (root == null) return 0;
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode<Integer> root, int level) {
        if (root == null ) return;

        if (level > maxLevel) {
            sum = 0;
            maxLevel = level;
        }

        if (level == maxLevel) {
            sum += root.getVal();
        }

        dfs(root.getLeft(), level + 1);
        dfs(root.getRight(), level + 1);

    }
}
