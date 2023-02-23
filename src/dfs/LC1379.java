package dfs;

import trees.TreeNode;

public class LC1379 {
    // DFS Preoder iterative!
    // public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    //     // Make a stack for iteration
    //     Deque<TreeNode> stack = new ArrayDeque<>();
    //     // Push the root of cloned
    //     stack.push(cloned);
    //     // Push the root of original
    //     stack.push(original);
    //     // Iterate
    //     while (!stack.isEmpty()) {
    //         // Pop original
    //         TreeNode curr = stack.pop();
    //         // Pop clone
    //         TreeNode clone = stack.pop();
    //         // Compare
    //         if (curr == target) return clone;
    //         // Visit left and right children for both now
    //         if (clone.right != null) stack.push(clone.right);
    //         // Same for original
    //         if (curr.right != null) stack.push(curr.right);
    //         if (clone.left != null) stack.push(clone.left);
    //         // Same for original left
    //         if (curr.left != null) stack.push(curr.left);
    //     }
    //     return null;
    // }

    // DFS pre-order version recusrive
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        if (original == target) return cloned;
        // Search left and right
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) return left;
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        if (right != null) return right;
        return null;
    }
}
