package trees;

import java.util.ArrayDeque;
import java.util.Deque;

class MaximumDepthOfBinaryTree_104 {
    public int maxDepth(TreeNode<Integer> root) {

        if (root == null) {
            return 0;
        }

        int level = 0;

        Deque<TreeNode<Integer>> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();

            while (n-- != 0) {
                TreeNode<Integer> curr = q.poll();

                if (curr.getLeft() != null) {
                    q.add(curr.getLeft());
                }

                if (curr.getRight() != null) {
                    q.add(curr.getRight());
                }
            }
            level++;
        }
        return level;
    }
}