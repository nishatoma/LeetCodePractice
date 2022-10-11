package bfs;

import trees.TreeNode;

import java.util.*;

public class BfsTraversalII_107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();

            while (size-- != 0) {
                TreeNode<Integer> curr = q.poll();
                temp.add(curr.getVal());
                if (curr.getLeft() != null) q.offer(curr.getLeft());
                if (curr.getRight() != null) q.offer(curr.getRight());
            }
            res.add(0, temp);
        }
        return res;
    }
}
