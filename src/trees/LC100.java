package trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        // Make a stack for iterating
        Deque<TreeNode> stack = new ArrayDeque<>();
        // We can use pre-order here
        stack.push(p);
        // Make another for q
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack2.push(q);
        // Iterate
        while (!stack.isEmpty() && !stack2.isEmpty()) {
            // Get current element
            TreeNode curr = stack.pop();
            // Get its value
            TreeNode curr2 = stack2.pop();
            if (curr.val != curr2.val) return false;
            // push all values in for children
            if (curr.right != null) stack.push(curr.right);
            if (curr2.right != null) stack2.push(curr2.right);
            // Check stack sizes here
            if (stack.size() != stack2.size()) return false;
            if (curr.left != null) stack.push(curr.left);
            if (curr2.left != null) stack2.push(curr2.left);
            // Check stack sizes here again
            if (stack.size() != stack2.size()) return false;
        }
        return true;
    }
}
