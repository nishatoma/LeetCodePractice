package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTreePruning_814 {

    public TreeNode<Integer> pruneTree(TreeNode<Integer> root) {
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

                    if (x.getLeft() == null && x.getRight() == null && x.getVal() == 0) {
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
