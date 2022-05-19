package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeInOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();

        TreeNode<Integer> curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            }

            // process the nodes
            curr = stack.pop();
            list.add(curr.getVal());

            curr = curr.getRight();
        }

        return list;
    }
}
