package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumDifferenceBetweenNodeAndAncestor_1026 {

    static class Triplet {
        TreeNode<Integer> root;
        int min;
        int max;

        public Triplet(TreeNode<Integer> root, int min, int max) {
            this.root = root;
            this.min = min;
            this.max = max;
        }

    }

    public int maxAncestorDiff(TreeNode<Integer> root) {
        if (root == null) return 0;
        Deque<Triplet> stack = new ArrayDeque<>();
        stack.push(new Triplet(root, root.getVal(), root.getVal()));

        int res = 0;
        int currMax = 0, currMin = 0;

        while (!stack.isEmpty()) {
            Triplet trip = stack.pop();
            TreeNode<Integer> curr = trip.root;


            currMin = Math.min(trip.min, curr.getVal());
            currMax = Math.max(trip.max, curr.getVal());

            if (curr.getRight() == null && curr.getLeft() == null) {
                res = Math.max(res, Math.abs(currMax - currMin));
            }


            if (curr.getRight() != null) {
                stack.push(new Triplet(curr.getRight(), currMin, currMax));
            }

            if (curr.getLeft() != null) {
                stack.push(new Triplet(curr.getLeft(), currMin, currMax));
            }
        }

        return res;

    }
}
