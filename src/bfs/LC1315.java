package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LC1315 {
    public int sumEvenGrandparent(TreeNode root) {
        // Idea behind bfs is to keep storing
        // the parent and its child in a map
        // then access the gp tah way
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        // res
        int res = 0;
        // current level
        int level = 1;
        // Iterate
        while (!q.isEmpty()) {
            // get current size
            int size = q.size();
            // Iterate over that level
            while (size-- != 0) {
                TreeNode curr = q.poll();
                // If we are above a certain level
                // we have a grandpa then.
                if (level >= 3) {
                    int gp = (int) map.get(map.get(curr)).val;
                    if ((gp & 1) == 0) {
                        res = res + (int) curr.val;
                    }
                }
                // Explore rest of children
                if (curr.left != null) {
                    q.offer(curr.left);
                    // let child point to parent
                    map.put(curr.left, curr);
                }
                // Same with right subtree
                if (curr.right != null) {
                    q.offer(curr.right);
                    map.put(curr.right, curr);
                }
            }
            level++;
        }
        return res;
    }
}
