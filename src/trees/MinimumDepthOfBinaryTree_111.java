package trees;

import java.util.ArrayDeque;
import java.util.Queue;

class MinimumDepthOfBinaryTree_111 {
    public int minDepth(TreeNode<Integer> root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode<Integer>> q = new ArrayDeque<>();
        q.add(root);
        int level = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {
                TreeNode<Integer> curr = q.poll();

                if (curr.getLeft() == null && curr.getRight() == null) {
                    return level;
                }

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
