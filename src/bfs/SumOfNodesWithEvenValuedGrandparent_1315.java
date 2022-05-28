package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfNodesWithEvenValuedGrandparent_1315 {

    public int sumEvenGrandparent(TreeNode<Integer> root) {
        int sum = 0;

        Deque<TreeNode<Integer>> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode<Integer> curr = q.poll();

            // If the number is even
            if ((curr.getVal() & 1) == 0) {
                // Find all grandchildren and add their sum
                if (curr.getRight() != null && curr.getRight().getRight() != null) sum += curr.getRight().getRight().getVal();
                if (curr.getRight() != null && curr.getRight().getLeft() != null) sum += curr.getRight().getRight().getVal();
                if (curr.getLeft() != null && curr.getLeft().getRight() != null) sum += curr.getLeft().getRight().getVal();
                if (curr.getLeft() != null && curr.getLeft().getLeft() != null) sum += curr.getLeft().getLeft().getVal();
            }

            if (curr.getLeft() != null) q.offer(curr.getLeft());
            if (curr.getRight() != null) q.offer(curr.getRight());
        }
        return sum;
    }
}
