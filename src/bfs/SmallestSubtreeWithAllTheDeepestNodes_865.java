package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SmallestSubtreeWithAllTheDeepestNodes_865 {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        TreeNode<Integer>[] farthest = getFarthestLeaves(root);

        return lca(root, farthest[0].getVal(), farthest[1].getVal());
    }

    private TreeNode[] getFarthestLeaves(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        TreeNode left = null;
        TreeNode right = null;

        while (!q.isEmpty()) {

            int n = q.size();

            for (int i = 0; i < n; ++i) {
                TreeNode curr = q.poll();

                if (i == 0) left = curr;
                if (i == n - 1) right = curr;

                if (curr.getLeft() != null) q.offer(curr.getLeft());
                if (curr.getRight() != null) q.offer(curr.getRight());
            }
        }

        return new TreeNode[]{left, right};
    }

    private TreeNode lca(TreeNode<Integer> root, int n1, int n2) {
        if (root == null) return null;

        if (root.getVal() == n1 || root.getVal() == n2) return root;

        TreeNode left = lca(root.getLeft(), n1, n2);
        TreeNode right = lca(root.getRight(), n1, n2);

        if (left != null && right != null) return root;

        return right == null ? left : right;
    }
}
