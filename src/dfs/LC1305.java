package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // Make a list first
        List<Integer> res = new ArrayList<>();
        if (root1 == null && root2 == null) {
            return res;
        }
        // Make two stacks for iteration
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        TreeNode curr1 = root1;
        TreeNode curr2 = root2;
        // iterate over both
        while (!stack1.isEmpty() || !stack2.isEmpty() || curr1 != null || curr2 != null) {
            while (curr1 != null) {
                stack1.push(curr1);
                curr1 = curr1.left;
            }
            while (curr2 != null) {
                stack2.push(curr2);
                curr2 = curr2.left;
            }
            // If both are not empty
            if (!stack1.isEmpty() && !stack2.isEmpty()) {
                if ((int) stack1.peek().val < (int) stack2.peek().val) {
                    curr1 = stack1.pop();
                    res.add((int) curr1.val);
                    curr1 = curr1.right;
                } else {
                    curr2 = stack2.pop();
                    res.add(curr2.val);
                    curr2 = curr2.right;
                }
            } else if (!stack1.isEmpty()) {
                curr1 = stack1.pop();
                res.add(curr1.val);
                curr1 = curr1.right;
            } else if (!stack2.isEmpty()) {
                curr2 = stack2.pop();
                res.add(curr2.val);
                curr2 = curr2.right;
            }
        }

        return res;
    }
}
