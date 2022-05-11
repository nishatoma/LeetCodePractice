package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTreeToGreaterSearchTree_1038 {

    public TreeNode<Integer> bstToGst(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        TreeNode<Integer> curr = root;
        int sum = 0;

        while (!stack.isEmpty() || curr != null) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.getRight();
            }
            curr = stack.pop();

            sum += curr.getVal();
            curr.setVal(sum);
            curr = curr.getLeft();

        }

        return root;
    }
}
