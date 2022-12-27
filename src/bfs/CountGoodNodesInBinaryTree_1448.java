package bfs;

import oop.Pair;
import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountGoodNodesInBinaryTree_1448 {

    public int goodNodes(TreeNode<Integer> root) {
        int res = 0;

        Deque<Pair<TreeNode<Integer>, Integer>> q = new ArrayDeque<>();
        q.push(new Pair<>(root, root.getVal()));

        while (!q.isEmpty()) {
            Pair<TreeNode<Integer>, Integer> pair = q.poll();
            TreeNode<Integer> curr = pair.getKey();
            int currMax = pair.getValue();

            if (curr.getVal() >= currMax) res++;

            if (curr.getLeft() != null) {
                q.offer(new Pair<>(curr.getLeft(), Math.max(currMax, curr.getLeft().getVal())));
            }

            if (curr.getRight() != null) {
                q.offer(new Pair<>(curr.getRight(), Math.max(currMax, curr.getRight().getVal())));
            }
        }

        return res;
    }
}
