package trees;

import java.util.ArrayDeque;
import java.util.Deque;

class InvertBinaryTree_226 {
    public TreeNode<Integer> invertTree(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<Integer> curr = stack.pop();
            TreeNode<Integer> right = curr.getRight();
            curr.setRight(curr.getLeft());
            curr.setLeft(right);

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
