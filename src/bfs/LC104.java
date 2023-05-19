package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.push(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- != 0) {
                TreeNode curr = q.poll();
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            ++res;
        }
        return res;
    }
}
