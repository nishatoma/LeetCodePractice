package dfs;

import kotlin.Pair;
import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumDepthOfBinaryTree_104 {

    public int maxDepth(TreeNode<Integer> root) {
        int max = 0;
        int depth = 1;
        if (root == null) return max;
        if (root.getLeft() == null && root.getRight() == null) return depth;

        Deque<Pair<TreeNode<Integer>, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair<>(root, depth));

        while (!stack.isEmpty()) {
            Pair<TreeNode<Integer>, Integer> pair = stack.pop();
            // Get current node and depth
            TreeNode<Integer> curr = pair.getFirst();
            depth = pair.getSecond();
            max = Math.max(depth, max);


            if (curr.getRight() != null) {
                stack.push(new Pair<>(curr.getRight(), depth + 1));
            }

            if (curr.getLeft() != null) {
                stack.push(new Pair<>(curr.getLeft(), depth + 1));
            }
        }

        return max;
    }
}
