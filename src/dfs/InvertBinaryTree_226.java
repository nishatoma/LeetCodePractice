package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class InvertBinaryTree_226 {

    public TreeNode<Integer> invertTree(TreeNode<Integer> root) {
        if (root == null) return null;

        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<Integer> curr = stack.pop();
            TreeNode<Integer> temp = curr.getLeft();
            // swap
            curr.setLeft(curr.getRight());
            curr.setRight(temp);

            if (curr.getRight() != null) {
                stack.push(curr.getRight());
            }

            if (curr.getLeft() != null) {
                stack.push(curr.getLeft());
            }

        }

        return root;
    }
}
