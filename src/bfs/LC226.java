package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        // Idea is to swap kids before
        // we process them.
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- != 0) {
                TreeNode curr = q.poll();
                // Swap
                TreeNode temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
                // Process the rest of the nodes
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
        // dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        dfs(root.left);
        dfs(root.right);
    }
}
