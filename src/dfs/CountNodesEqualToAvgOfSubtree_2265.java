package dfs;

import trees.TreeNode;

public class CountNodesEqualToAvgOfSubtree_2265 {

    int res = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = dfs(root.getLeft());
        int[] right = dfs(root.getRight());

        int currSum = left[0] + right[0] + (int) root.getVal();
        int count = left[1] + right[1] + 1;

        if (currSum / count == (int) root.getVal()) {
            res++;
        }

        return new int[]{currSum, count};
    }
}
