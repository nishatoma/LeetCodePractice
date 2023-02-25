package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean odd = false;
        while (!q.isEmpty()) {
            // get size
            int size = q.size();
            // Create an array
            TreeNode[] arr = new TreeNode[size];
            // Go over and just copy all elements
            for (int i = 0; i < size; ++i) {
                // get current node
                TreeNode curr = q.poll();
                // populate the array
                arr[i] = curr;
                // then push children
                if (curr.left != null) {
                    // Because this is a perfect tree
                    // We can safely assume that
                    // if we have a left child then we also have
                    // a right child
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
            }
            // check if odd
            if (odd) {
                // Reverse the elements in the array!
                reverse(arr);
            }
            // Toggle odd
            odd = !odd;
        }
        return root;
    }

    private void reverse(TreeNode[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        // Go over
        while (lo < hi) {
            // swap
            int temp = (int) arr[lo].val;
            arr[lo++].val = arr[hi].val;
            arr[hi--].val = temp;
        }
    }
}
