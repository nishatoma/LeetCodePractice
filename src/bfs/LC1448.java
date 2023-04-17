package bfs;

import oop.Pair;
import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1448 {
    public int goodNodes(TreeNode root) {
        int res = 0;
        Deque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair<>(root, Integer.MIN_VALUE));
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> curr = q.poll();
            if (curr.getKey().val >= curr.getValue()) {
                ++res;
            }

            if (curr.getKey().left != null) {
                q.offer(new Pair<>(curr.getKey().left, Math.max(curr.getKey().val, curr.getValue())));

            }
            if (curr.getKey().right != null) {
                q.offer(new Pair<>(curr.getKey().right, Math.max(curr.getKey().val, curr.getValue())));
            }
        }

        return res;
    }
}
