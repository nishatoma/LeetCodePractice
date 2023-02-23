package dfs;

import trees.TreeNode;

public class LC938 {
    public int rangeSumBST(TreeNode root, Integer lo, Integer hi) {
        // intitialize a sum variable
        int sum = 0;
        // Check base case
        if (root == null) return sum;
        // Check main condition
        if (lo <= (int) root.val && (int) root.val <= hi) {
            sum = (int) root.val;
        }
        // Add both left and right
        // One slight optimization, we can utlize the fact that
        // we have a BST!
        // If the current node value is greater than lo,
        // then, we can go lower by going left..
        if ((int) root.val > lo) {
            sum += rangeSumBST(root.left, lo, hi);
        }
        // Similar to right subtree
        if ((int) root.val < hi) {
            sum += rangeSumBST(root.right, lo, hi);
        }
        // return sum
        return sum;
    }

    // public int rangeSumBST(TreeNode root, int low, int high) {
    //     int[] sum = new int[1];
    //     return dfs2(root, low, high);
    //     // return sum[0];
    // }

    // Version with sum array
    private void dfs(TreeNode root, Integer lo, Integer hi, int[] sum) {
        if (root == null) return;

        if (lo <= (int)root.val && (int)root.val <= hi) {
            sum[0] += (int)root.val;
        }
        dfs(root.left, lo, hi, sum);
        dfs(root.right, lo, hi, sum);
        return;
    }

    // Version without sum array
    private int dfs2(TreeNode root, int lo, int hi) {
        int sum = 0;
        if (root == null) return 0;
        if (lo <= (int)root.val && (int)root.val <= hi) sum = (int) root.val;

        sum += dfs2(root.left, lo, hi) + dfs2(root.right, lo, hi);

        return sum;
    }
}
