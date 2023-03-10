package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LC1315 {
    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        if (root.left == null && root.right == null) {
            return sum;
        }
        // Map a node to its ancestors
        Map<TreeNode, TreeNode[]> map = new HashMap<>();
        // Deque for traversal
        Deque<TreeNode> stack = new ArrayDeque<>();
        // Push root for pre-order
        stack.push(root);
        // Put in map
        // The root has null parent and grand-parent
        map.put(root, new TreeNode[]{null, null});
        // Iterate
        while (!stack.isEmpty()) {
            // Get current node
            TreeNode node = stack.pop();
            // Check its gp node
            TreeNode[] ancestors = map.get(node);
            if (ancestors[1] != null && (int) ancestors[1].val % 2 == 0) {
                sum = sum + (int) node.val;
            }
            // Process child nodes
            if (node.right != null) {
                stack.push(node.right);
                // Update map
                map.put(node.right, new TreeNode[]{node, map.get(node)[0]});
            }
            // Same with left child
            if (node.left != null) {
                stack.push(node.left);
                map.put(node.left, new TreeNode[]{node, map.get(node)[0]});
            }
        }
        // return sumDfs(root, null, null);
        return sum;
    }

    private int sumDfs(TreeNode root, TreeNode parent, TreeNode grandparent) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (grandparent != null && (int) grandparent.val % 2 == 0) {
            sum = sum + (int) root.val;
        }
        sum += sumDfs(root.left, root, parent);
        sum += sumDfs(root.right, root, parent);

        return sum;
    }
}
