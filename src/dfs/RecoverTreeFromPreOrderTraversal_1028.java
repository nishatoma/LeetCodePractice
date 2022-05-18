package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecoverTreeFromPreOrderTraversal_1028 {
    public TreeNode<Integer> recoverFromPreorder(String string) {

        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        int n = string.length();

        for (int i = 0; i < n; ) {
            int level = 0;
            int val = 0;

            while (i < n && string.charAt(i) == '-') {
                ++level;
                ++i;
            }

            while (i < n && string.charAt(i) != '-') {
                val = val * 10 + (string.charAt(i) - '0');
                ++i;
            }

            TreeNode<Integer> root = new TreeNode<Integer>(val);

            if (stack.isEmpty()) {
                stack.push(root);
                continue;
            }

            while (stack.size() > level) {
                stack.pop();
            }

            if (stack.peek().getLeft() == null) {
                stack.peek().setLeft(root);
            } else {
                stack.peek().setRight(root);
            }
            stack.push(root);
        }

        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.pop();

    }
}
