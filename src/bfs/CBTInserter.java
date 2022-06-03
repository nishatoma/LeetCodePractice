package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

class CBTInserter {

    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int val) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode<Integer> curr = q.poll();
            // Check 2 children
            if (curr.getRight() == null) {
                if (curr.getLeft() == null) {
                    curr.setLeft(new TreeNode(val));
                } else {
                    curr.setRight(new TreeNode(val));
                }
                return curr.getVal();
            }

            if (curr.getLeft() != null) q.offer(curr.getLeft());
            if (curr.getRight() != null) q.offer(curr.getRight());
        }

        return val;
    }

    public TreeNode get_root() {
        return root;
    }
}