package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BalanceBST_1382 {

    public TreeNode<Integer> balanceBST(TreeNode<Integer> root) {

        List<TreeNode<Integer>> list = new ArrayList<>();
        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            root = stack.pop();
            list.add(root);
            root = root.getRight();
        }

        if (list.isEmpty()) return null;

        return constructBST(list, 0, list.size() - 1);
    }


    private TreeNode<Integer> constructBST(List<TreeNode<Integer>> list, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode<Integer> root = list.get(mid);
        root.setLeft(constructBST(list, start, mid - 1));
        root.setRight(constructBST(list, mid + 1, end));

        return root;
    }
}
