package dfs;

import trees.TreeNode;

public class SumOfNodesWithEvenValueGrandParents_1315 {

    private int sum = 0;

    public int sumEvenGrandparent(TreeNode<Integer> root) {
        dfs(root, null, null);

        return sum;
    }

    private void dfs(TreeNode<Integer> curr, TreeNode<Integer> parent, TreeNode<Integer> grand) {
        if (curr == null) return;

        if (grand != null && (grand.getVal() & 1) == 0) {
            sum += curr.getVal();
        }

        dfs(curr.getLeft(), curr, parent);
        dfs(curr.getRight(), curr, parent);
    }
}
