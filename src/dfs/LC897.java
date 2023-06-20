package dfs;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC897 {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        getInOrder(root, list);
        TreeNode newRoot = new TreeNode();
        TreeNode curr = newRoot;
        for (TreeNode node : list) {
            curr.right = new TreeNode(node.val);
            curr = curr.right;
        }
        return newRoot.right;
    }

    private void getInOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        getInOrder(root.left, list);
        list.add(root);
        getInOrder(root.right, list);
    }
}
