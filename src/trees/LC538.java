package trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC538 {
    public TreeNode convertBST(TreeNode root) {
        // Do a reverse-pre order?
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        TreeNode prev = null;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }

            // Pop
            TreeNode node = stack.pop();
            node.val += prev == null ? 0 : prev.val;
            prev = node;
            curr = node.left;
        }

        return root;
    }
}
