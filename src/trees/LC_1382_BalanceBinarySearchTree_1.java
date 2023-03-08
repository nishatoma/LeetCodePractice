package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC_1382_BalanceBinarySearchTree_1 {
    public TreeNode balanceBST(TreeNode root) {
        // Make an array first of all the nodes
        // using in-order traversal
        List<Integer> list = new ArrayList<>();
        // Make a stack for in-order traversal
        Deque<TreeNode> stack = new ArrayDeque<>();
        // Make a curr pointer starting at root
        TreeNode curr = root;
        // Iterate
        while (curr != null || !stack.isEmpty()) {
            // Push all the way left
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Pop the node here and process it
            TreeNode node = stack.pop();
            // Add it to list
            list.add((int) node.val);
            // Now assign the curr value to the right node if it exists
            curr = node.right;
        }
        // Now that we have a list, construct a new tree node
        // Starting from middle value of list..
        TreeNode res = constructBalancedBst(list, 0, list.size() - 1);
        return res;
    }

    private TreeNode constructBalancedBst(List<Integer> list, int lo, int hi) {
        // base case
        if (lo > hi) {
            return null;
        }

        // Get teh middle element
        int mid = lo + (hi - lo) / 2;
        // Construct the root here first
        TreeNode root = new TreeNode(list.get(mid));
        root.left = constructBalancedBst(list, lo, mid - 1);
        root.right = constructBalancedBst(list, mid + 1, hi);
        return root;
    }
}
