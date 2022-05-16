package dfs;

import trees.BTreePrinter;
import trees.TreeNode;

public class DeleteLeavesWithGivenValue_1325 {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);

        root.setLeft(new TreeNode<>(2));
        root.getLeft().setLeft(new TreeNode<>(2));
        root.setRight(new TreeNode<>(3));
        root.getRight().setLeft(new TreeNode<>(2));
        root.getRight().setRight(new TreeNode<>(4));

        BTreePrinter.printNode(removeLeafNodes(root, 2));

    }
    private static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root, int target) {
        if (root == null) return null;

        root.setLeft(removeLeafNodes(root.getLeft(), target));
        root.setRight(removeLeafNodes(root.getRight(), target));



        return (root.getVal() == target && root.getLeft() == null && root.getRight() == null ? null : root);
    }
}
