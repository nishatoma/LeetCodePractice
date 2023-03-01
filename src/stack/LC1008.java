package stack;

import trees.TreeNode;

public class LC1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstBound(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private TreeNode bstBound(int[] A, int bound, int[] i) {
        // Base case
        // If we reached the last element, or, we are outside bound
        if (i[0] == A.length || A[i[0]] > bound) {
            return null;
        }
        TreeNode root = new TreeNode(A[i[0]++]);
        root.left = bstBound(A, root.val, i);
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
