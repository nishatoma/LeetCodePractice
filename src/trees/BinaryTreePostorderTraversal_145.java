package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreePostorderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode<Integer> root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode<Integer>> stack1 = new Stack<>();
        Stack<TreeNode<Integer>> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode<Integer> curr = stack1.pop();
            stack2.push(curr);

            if (curr.getLeft() != null) {
                stack1.push(curr.getLeft());
            }

            if (curr.getRight() != null) {
                stack1.push(curr.getRight());
            }
        }

        while(!stack2.isEmpty()){
            result.add(stack2.pop().getVal());
        }

        return result;
    }
}