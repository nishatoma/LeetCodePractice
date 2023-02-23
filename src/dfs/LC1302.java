package dfs;

import trees.TreeNode;

public class LC1302 {
    // For this specific method, we can use DFS with arrays for
    // maxDepth and our result!!
    public int deepestLeavesSum(TreeNode root) {
        // init res and maxdepth arrays
        int[] maxDepth = new int[1];
        int[] res = new int[1];
        dfs(root, 0, maxDepth, res);
        return res[0];
    }

    private void dfs(TreeNode root, int currDepth, int[] maxDepth, int[] res) {
        // Base case
        if (root == null) return;

        // Check current depth
        if (currDepth > maxDepth[0]) {
            maxDepth[0] = currDepth;
            // Reset the sum
            res[0] = (int) root.val;
        } else if (currDepth == maxDepth[0]) {
            // Otherwise, we can just add to the sum!
            res[0] = res[0] + (int) root.val;
        }
        // Repeat process for left and right children
        dfs(root.left, currDepth + 1, maxDepth, res);
        dfs(root.right, currDepth + 1, maxDepth, res);
    }


    // Now, even better approach!
    // Simply reset the sum at each level!
    // public int deepestLeavesSum(TreeNode root) {
    //     // BFS again, but this time,
    //     // We don't need a map. Just simply reset the sum whenever we go to the next level
    //     int res = 0, i;
    //     Deque<TreeNode> q = new ArrayDeque<>();
    //     q.offer(root);
    //     while (!q.isEmpty()) {
    //         for (i = q.size(), res = 0; i > 0; --i) {
    //             TreeNode curr = q.poll();
    //             // get sum
    //             res += curr.val;
    //             // process the rest
    //             if (curr.left != null) q.offer(curr.left);
    //             if (curr.right != null) q.offer(curr.right);
    //         }
    //     }
    //     return res;
    // }

    // public int deepestLeavesSum(TreeNode root) {
    //     // BFS solution
    //     // Perhaps we don't have to visit the tree twice
    //     // Just once maybe for max depth
    //     // Then store each node and map it to its depth in a map
    //     int maxDepth = 0;
    //     int currDepth = 0;
    //     int res = 0;
    //     // Make a queue for iteration
    //     Deque<TreeNode> q = new ArrayDeque<>();
    //     // Make a map for storing tree node values and their depth
    //     Map<TreeNode, Integer> map = new HashMap<>();
    //     // Offer the root
    //     q.offer(root);
    //     // Iterate
    //     while (!q.isEmpty()) {
    //         // Get current size
    //         int size = q.size();
    //         // Increase depth
    //         currDepth++;
    //         // go over the level
    //         while (size-- != 0) {
    //             TreeNode curr = q.poll();
    //             // Store in map as current depth
    //             // Maybe a good idea to only store leaf nodes
    //             if (curr.left == null && curr.right == null) {
    //                 map.put(curr, currDepth);
    //                 continue;
    //             }
    //             // process left and right children
    //             if (curr.left != null) q.offer(curr.left);
    //             if (curr.right != null) q.offer(curr.right);
    //         }
    //     }
    //     // Now iterate for each key
    //     for (TreeNode key : map.keySet()) {
    //         if (map.get(key) == currDepth) {
    //             res += key.val;
    //         }
    //     }
    //     return res;
    // }

    // public int deepestLeavesSum(TreeNode root) {
    //     // Find max level first using iteration, maybe we can use
    //     // Inorder trversal here
    //     int maxDepth = 0;
    //     int currDepth = 0;
    //     // Make a stack for traversal
    //     Deque<TreeNode> stack = new ArrayDeque<>();
    //     // Make a current node point to root
    //     TreeNode curr = root;
    //     TreeNode lastVisited = null;
    //     // Iterate using post-order, since we are guaranteed
    //     // to visit deeper nodes first!!
    //     while (curr != null || !stack.isEmpty()) {
    //         while (curr != null) {
    //             stack.push(curr);
    //             curr = curr.left;
    //             ++currDepth;
    //         }
    //         // Peek
    //         TreeNode node = stack.peek();
    //         // get maxDepth
    //         maxDepth = Math.max(maxDepth, currDepth);
    //         // check if we can visit more
    //         if (node.right != null && node.right != lastVisited) {
    //             // Then process right and keep increasing depth
    //             curr = node.right;
    //         } else {
    //             curr = null;
    //             stack.pop();
    //             lastVisited = node;
    //             currDepth--;
    //         }
    //     }

    //     // Now we have maxDepth, use that to find the leaf sums that have that depth..
    //     // We can use post-order here maybe
    //     curr = root;
    //     lastVisited = null;
    //     // Reset currDepth
    //     currDepth = 0;
    //     // total res
    //     int res = 0;
    //     // Iterate
    //     System.out.println(maxDepth);
    //     while (curr != null || !stack.isEmpty()) {
    //         // we cna use if version here
    //         if (curr != null) {
    //             stack.push(curr);
    //             curr = curr.left;
    //             ++currDepth;
    //         } else {
    //             // peek current node
    //             TreeNode node = stack.peek();
    //             // Check if leaf node
    //             if (node.left == null && node.right == null) {
    //                 // check max
    //                 if (currDepth == maxDepth) {
    //                     res += node.val;
    //                 }
    //             }

    //             // Iterate over right children if any
    //             if (node.right != null && node.right != lastVisited) {
    //                 // Explore right
    //                 curr = node.right;
    //             } else {
    //                 // Otherwise just pop
    //                 // Decrease depth
    //                 --currDepth;
    //                 stack.pop();
    //                 lastVisited = node;
    //             }
    //         }
    //     }

    //     return res;
    // }

    private int dfs(TreeNode root, int currDepth, int maxDepth) {
        if (root == null) return 0;
        if (root.left == null && root.right == null && ++currDepth == maxDepth) return (int) root.val;

        int left = dfs(root.left, currDepth + 1, maxDepth);
        int right = dfs(root.right, currDepth + 1, maxDepth);

        return left + right;
    }


    // I guess we do need a method to calculate max depth first
    private int getMaxDepth(TreeNode root, int depth) {
        if (root == null) return depth;

        int left = getMaxDepth(root.left, depth + 1);
        int right = getMaxDepth(root.right, depth + 1);

        return Math.max(left, right);
    }
}
