package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LowestCommonAncestorOfDeepestLeaves_1123 {

    public TreeNode lcaDeepestLeaves(TreeNode<Integer> root) {

        TreeNode<Integer>[] far = findFarthestLeaves(root);
        TreeNode<Integer> left = far[0];
        TreeNode<Integer> right = far[1];

        TreeNode lc = lca(root, left.getVal(), right.getVal());

        return lc;

    }

    // Find farthest deepest leaves
    private TreeNode[] findFarthestLeaves(TreeNode root) {
        if (root.getLeft() == null && root.getRight() == null) return new TreeNode[]{root, root};
        TreeNode left = null;
        TreeNode right = null;

        // BFS approach
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; ++i) {
                TreeNode curr = q.poll();

                // Farthest left
                if (i == 0) {
                    left = curr;
                }

                // Farthest right
                if (i == n - 1) {
                    right = curr;
                }

                if (curr.getLeft() != null) q.offer(curr.getLeft());
                if (curr.getRight() != null) q.offer(curr.getRight());
            }
        }

        return new TreeNode[]{left, right};
    }

    // Returns LCA of two nodes
    private TreeNode lca(TreeNode<Integer> root, int n1, int n2) {
        if (root == null) return null;

        if (root.getVal() == n1 || root.getVal() == n2) return root;

        TreeNode left = lca(root.getLeft(), n1, n2);
        TreeNode right = lca(root.getRight(), n1, n2);

        if (left != null && right != null) return root;

        return left == null ? right : left;
    }
}
