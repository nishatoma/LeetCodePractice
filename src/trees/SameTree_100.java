package trees;

import java.util.Stack;

class SameTree_100 {

    public boolean isSameTree(TreeNode<Integer> p, TreeNode<Integer> q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        Stack<TreeNode<Integer>> stack1 = new Stack<>();
        Stack<TreeNode<Integer>> stack2 = new Stack<>();

        stack1.add(p);
        stack2.add(q);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode<Integer> curr1 = stack1.pop();
            TreeNode<Integer> curr2 = stack2.pop();

            if (curr1.getVal() != curr2.getVal()) {
                return false;
            }

            if (curr1.getRight() == null && curr2.getRight() != null) {
                return false;
            }

            if (curr2.getRight() == null && curr1.getRight() != null) {
                return false;
            }

            if (curr1.getRight() != null) {
                stack1.push(curr1.getRight());
            }

            if (curr1.getLeft() != null) {
                stack1.push(curr1.getLeft());
            }

            if (curr2.getRight() != null) {
                stack2.push(curr2.getRight());
            }

            if (curr2.getLeft() != null) {
                stack2.push(curr2.getLeft());
            }
        }
        return true;
    }
}