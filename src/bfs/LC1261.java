package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class LC1261 {
    Set<Integer> set;

    public LC1261(TreeNode root) {
        set = new HashSet<>();
        root.val = 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        set.add(root.val);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                curr.left.val = curr.val * 2 + 1;
                q.offer(curr.left);
                set.add(curr.left.val);
            }
            if (curr.right != null) {
                curr.right.val = curr.val * 2 + 2;
                q.offer(curr.right);
                set.add(curr.right.val);
            }
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
