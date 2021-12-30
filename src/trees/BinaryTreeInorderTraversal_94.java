package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreeInorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode<Integer> root) {

        List<Integer> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            }

            curr = stack.pop();
            result.add(curr.getVal());
            curr = curr.getRight();
        }

        return result;
    }
}


