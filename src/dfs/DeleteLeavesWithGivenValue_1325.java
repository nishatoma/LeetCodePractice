package dfs;

import trees.BTreePrinter;
import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeleteLeavesWithGivenValue_1325 {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);

        root.setLeft(new TreeNode<>(2));
        root.getLeft().setLeft(new TreeNode<>(2));
        root.setRight(new TreeNode<>(3));
        root.getRight().setLeft(new TreeNode<>(2));
        root.getRight().setRight(new TreeNode<>(4));

        BTreePrinter.printNode(removeLeafNodes(root, 2));
        BTreePrinter.printNode(removeLeafNodes(root, 4));
        BTreePrinter.printNode(removeLeafNodes(root, 1));

    }
    private static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root, int target) {
        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        TreeNode<Integer> curr = root;
        TreeNode<Integer> prev = null;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            } else {
                TreeNode<Integer> x = stack.peek();

                if (x.getRight() == null || x.getRight() == prev) {
                    stack.pop();
                    prev = x;

                    if (x.getLeft() == null && x.getRight() == null && x.getVal() == target) {
                        TreeNode<Integer> parent = stack.peek();

                        if (stack.isEmpty()) return null;

                        if (parent.getLeft() == x) {
                            parent.setLeft(null);
                        }

                        if (parent.getRight() == x) {
                            parent.setRight(null);
                        }
                    }
                } else {
                    curr = x.getRight();
                }
            }
        }

        return root;
    }
}
