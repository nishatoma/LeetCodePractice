package tries;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // return construct(nums, 0, nums.length - 1);
        Deque<TreeNode> stack = new ArrayDeque<>();

        for (int i = 0; i < nums.length; ++i) {
            // Make a new node
            TreeNode curr = new TreeNode(nums[i]);
            // While we have a strictly decreasing order
            // Keep making the popped element
            // the left child of our current node
            while (!stack.isEmpty() && (int) stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            // Otherwise, if the stack is not empty
            // Make the bigger element the parent
            // of our current node, with our current node
            // being the right child
            if (!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            // Finally, push the element into the stack
            stack.push(curr);
        }
        return stack.isEmpty() ? null : stack.pollLast();
    }

    // Recursive solution, is best case O(N Log N)
    // Worse case for monotonicall increasing/decreasing tree
    // is O(N * N)
    private TreeNode construct(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int index = findIndex(nums, lo, hi);
        // Make a tree
        TreeNode root = new TreeNode(nums[index]);
        root.left = construct(nums, lo, index - 1);
        root.right = construct(nums, index + 1, hi);
        return root;
    }

    private int findIndex(int[] nums, int lo, int hi) {
        int max = -1;
        int index = 0;
        for (int i = lo; i <= hi; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
