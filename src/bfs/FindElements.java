package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class FindElements {
    private Set<Integer> set;

    public FindElements(TreeNode root) {
        // init hashmap
        set = new HashSet<>();
        // use BFS
        Deque<TreeNode> q = new ArrayDeque<>();
        root.val = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- != 0) {
                TreeNode curr = q.poll();
                // check siblings now
                if (curr.left != null) {
                    // change value
                    curr.left.val = (int) curr.val * 2 + 1;
                    // add to map
                    set.add((int) curr.left.val);
                    // process
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    // change value
                    curr.right.val = (int) curr.val * 2 + 2;
                    // add to map
                    set.add((int) curr.right.val);
                    // process
                    q.offer(curr.right);
                }
            }
        }
    }

    public boolean find(int target) {
        // check hashmap value first
        return (target == 0 || set.contains(target));
    }
}