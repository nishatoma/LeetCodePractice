package bfs;

import jdk.internal.net.http.common.Pair;
import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfLeftLeaves_404 {

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;

        Deque<Pair<TreeNode, Boolean>> q = new ArrayDeque<>();
        q.offer(new Pair(root, false));

        while (!q.isEmpty()) {
            Pair<TreeNode, Boolean> pair = q.poll();
            TreeNode<Integer> curr = pair.first;
            boolean isLeft = pair.second;

            if (isLeft && curr.getLeft() == null && curr.getRight() == null) {
                sum += curr.getVal();
            }

            if (curr.getLeft() != null) {
                q.offer(new Pair<>(curr.getLeft(), true));
            }

            if (curr.getRight() != null) {
                q.offer(new Pair<>(curr.getRight(), false));
            }
        }
        return sum;
    }
}
