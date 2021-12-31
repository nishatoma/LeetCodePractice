package trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class DiameterOfBinaryTree_543 {
    public int diameterOfBinaryTree(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int result = 0;

        Map<TreeNode<Integer>, Integer> maxNodeVisited = new HashMap<>();
        Stack<TreeNode<Integer>> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<Integer> curr = stack.peek();

            if (curr.getLeft() != null && !maxNodeVisited.containsKey(curr.getRight())) {
                stack.push(curr.getLeft());
            } else if (curr.getRight() != null && !maxNodeVisited.containsKey(curr.getRight())) {
                stack.push(curr.getRight());
            } else {
                TreeNode<Integer> popped = stack.pop();
                int left = maxNodeVisited.getOrDefault(popped.getLeft(), 0);
                int right = maxNodeVisited.getOrDefault(popped.getLeft(), 0);
                int nodeMax = 1 + Math.max(left, right);
                maxNodeVisited.put(popped, nodeMax);
                result = Math.max(result, left + right);
            }
        }

        return result;
    }
}