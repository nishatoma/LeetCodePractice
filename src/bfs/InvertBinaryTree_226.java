package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class InvertBinaryTree_226 {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;
        if (root.getLeft() == null && root.getRight() == null) return root;

        // BFS approach
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {

            TreeNode curr = q.poll();

            TreeNode temp = curr.getLeft();
            curr.setLeft(curr.getRight());
            curr.setRight(temp);

            if (curr.getLeft() != null) q.offer(curr.getLeft());
            if (curr.getRight() != null) q.offer(curr.getRight());
        }

        return root;
    }
}
