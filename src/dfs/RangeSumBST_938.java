package dfs;

import trees.TreeNode;

public class RangeSumBST_938 {

    public int rangeSumBST(TreeNode<Integer> root, int l, int r) {
        if (root == null) return 0;

        if (root.getVal() < l) return rangeSumBST(root.getRight(), l, r);
        if (root.getVal() > r) return rangeSumBST(root.getLeft(), l, r);

        return root.getVal() + rangeSumBST(root.getLeft(), l, r) + rangeSumBST(root.getRight(), l, r);
    }
}
