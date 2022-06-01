package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class UnivaluedBinaryTree_965 {

    public boolean isUnivalTree(TreeNode<Integer> root) {
        int val = root.getVal();

        Deque<TreeNode<Integer>> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode<Integer> curr = q.poll();

            if (curr.getVal() != val) return false;

            if (curr.getLeft() != null) q.offer(curr.getLeft());
            if (curr.getRight() != null) q.offer(curr.getRight());
        }

        return true;
    }
}
