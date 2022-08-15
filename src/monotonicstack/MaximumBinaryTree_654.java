package monotonicstack;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumBinaryTree_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode<Integer>> q = new ArrayDeque<>();

        for (int num : nums) {
            // Get the value
            TreeNode node = new TreeNode(num);
            // See if it is the max one
            while (!q.isEmpty() && q.peek().getVal() < num) {
                node.setLeft(q.peek());
                q.pop();
            }
            // If the q is not empty, then assign the right value
            if (!q.isEmpty()) {
                q.peek().setRight(node);
            }
            // add to q
            q.push(node);
        }
        // Empty the q
        while (q.size() != 1) q.pop();
        // Return root node
        return q.peek();
    }
}
