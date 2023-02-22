package trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC111 {
    public int minDepth(TreeNode root) {
        // Let's try BFS
        if (root == null) return 0;
        // MAke a queue
        Deque<TreeNode> q = new ArrayDeque<>();
        // Make a res var
        int res = Integer.MAX_VALUE;
        // Make a depth var
        int depth = 1;
        // Push root
        q.offer(root);
        // Iterate
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- != 0) {
                // Get current element
                // If it's a leaf node, record the
                // current depth and compare to min
                TreeNode curr = q.poll();
                // if leaf
                if (curr.left == null && curr.right == null) {
                    // Compare min
                    if (depth < res) {
                        res = depth;
                        // Break here, no need to go further
                        break;
                    }
                }
                // Add the rest
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            // Increase depth
            ++depth;
        }
        return res;
    }

    // Post-Order solution
    // public int minDepth(TreeNode root) {
    // Let's try post-order traversal now
    // if (root == null) return 0;
    // // Make a stack
    // Deque<TreeNode> stack = new ArrayDeque<>();
    // // Make reference to curr and lastVisited
    // TreeNode curr = root;
    // TreeNode lastVisited = null;
    // // Make a reference to res
    // int depth = 0;
    // int res = Integer.MAX_VALUE;
    // // Iterate
    // while (curr != null || !stack.isEmpty()) {
    //     // WE can do this either with a while or if statement
    //     // let's choose the if statement this time
    //     if (curr != null) {
    //         stack.push(curr);
    //         curr = curr.left;
    //         // increase depth here
    //         ++depth;
    //     } else {
    //         // Otherwise, peek
    //         TreeNode node = stack.peek();
    //         // If we have a right child explore it
    //         if (node.right != null && node.right != lastVisited) {
    //             curr = node.right;
    //         } else {
    //             // Otherwise, time to process the node
    //             // Increase the depth here
    //             boolean isLeaf = node.right == null && node.left == null;
    //             if (isLeaf) {
    //                 res = Math.min(res, depth);
    //             }
    //             // pop
    //             stack.pop();
    //             // Decrease depth here "Backtrack"
    //             --depth;
    //             // Mark last visited
    //             lastVisited = node;
    //         }
    //     }
    // }
    // return res;
    // }

    private int depth(TreeNode root, int depth) {
        if (root.left == null && root.right == null) return depth;
        int left = root.left != null ? depth(root.left, depth + 1) : Integer.MAX_VALUE;
        int right = root.right != null ? depth(root.right, depth + 1) : Integer.MAX_VALUE;

        return Math.min(left, right);
    }
}
