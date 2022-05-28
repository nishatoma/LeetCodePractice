package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeepestLeavesSum_1302 {

    public int deepestLeavesSum(TreeNode<Integer> root) {


        Deque<TreeNode<Integer>> q = new ArrayDeque<>();
        q.push(root);

        int res = 0;
        while (!q.isEmpty()) {

            int n = q.size();
            res = 0;

            while (n-- != 0) {
                TreeNode<Integer> curr = q.poll();

                res += curr.getVal();

                if (curr.getLeft() != null) q.offer(curr.getLeft());
                if (curr.getRight() != null) q.offer(curr.getRight());
            }
        }
        return res;
    }
}
