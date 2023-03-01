package stack;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        // return bstBound(preorder, Integer.MAX_VALUE, new int[]{0});
        // Iterative solution
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        // Push root first
        stack.push(root);
        // Iterate over the rest
        for (int i = 1; i < preorder.length; ++i) {
            TreeNode curr = new TreeNode(preorder[i]);
            if ((int) stack.peek().val > (int) curr.val) {
                // Then make it a left child
                stack.peek().left = curr;
            } else {
                // Otherwise, we keep popping basically
                // Then making the last parent as the parent
                // of this right child
                TreeNode parent = stack.peek();
                while (!stack.isEmpty() && (int) stack.peek().val < (int) curr.val) {
                    parent = stack.pop();
                }
                // Make this the right child
                parent.right = curr;
            }
            // Push current element
            stack.push(curr);
        }
        return root;
    }

    private TreeNode bstBound(int[] A, int bound, int[] i) {
        // Base case
        // If we reached the last element, or, we are outside bound
        if (i[0] == A.length || A[i[0]] > bound) {
            return null;
        }
        TreeNode root = new TreeNode(A[i[0]++]);
        root.left = bstBound(A, (int) root.val, i);
        root.right = bstBound(A, bound, i);
        return root;
    }

    public TreeNode bstFromPreorderRecursive(int[] preorder) {
        return dfs(preorder, 0, preorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int start, int end) {
        if (start > end) return null;

        // Make root node
        TreeNode root = new TreeNode(preorder[start]);
        // Find index of the first greater element
        int greaterIndex = end + 1;
        for (int i = start; i <= end; ++i) {
            if (preorder[i] > (int) root.val) {
                greaterIndex = i;
                break;
            }
        }

        // Recurse
        root.left = dfs(preorder, start + 1, greaterIndex - 1);
        root.right = dfs(preorder, greaterIndex, end);
        return root;
    }
}
