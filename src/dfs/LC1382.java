package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC1382 {
    public TreeNode balanceBST(TreeNode root) {
        // We can perform in-order to construct a list first
        Deque<TreeNode> stack = new ArrayDeque<>();
        // Construct a list
        List<TreeNode> list = new ArrayList<>();
        // Make a curr pointer
        TreeNode curr = root;
        // iterate
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // Pop current element
            TreeNode node = stack.pop();
            // add to list
            list.add(node);
            // Update curr
            curr = node.right;
        }
        // Construct a balanced tree from our list
        TreeNode newRoot = constructBalancedBst(list, 0, list.size() - 1);
        // Return the new constructed tree
        return newRoot;
    }

    private TreeNode constructBalancedBst(List<TreeNode> list, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        // Get the middle
        int mid = lo + (hi - lo) / 2;
        // Get the element at mid
        TreeNode root = new TreeNode(list.get(mid).val);
        // Construct left
        root.left = constructBalancedBst(list, lo, mid - 1);
        root.right = constructBalancedBst(list, mid + 1, hi);
        return root;
    }
}
