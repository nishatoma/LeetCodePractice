package dp;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees_894 {

    public List<TreeNode> allPossibleFBT(int n) {
        if (n <= 0) return new ArrayList<>();

        List<TreeNode>[] dp = new ArrayList[n + 1];

        for (int i = 0; i <= n; ++i) {
            dp[i] = new ArrayList<>();
        }
        dp[1].add(new TreeNode(0));

        for (int i = 1; i <= n; i += 2) {
            for (int left = 1; left < i; left += 2) {
                for (TreeNode leftN : dp[left]) {
                    for (TreeNode right : dp[i - 1 - left]) {
                        TreeNode root = new TreeNode(0);
                        root.setLeft(leftN);
                        root.setRight(right);
                        dp[i].add(root);
                    }
                }
            }
        }
        return dp[n];
    }
}
