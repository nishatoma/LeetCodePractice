package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class IncreasingOrderSearchTree_897 {

    public TreeNode<Integer> increasingBST(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        List<TreeNode<Integer>> list = new ArrayList<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }

            root = stack.pop();
            root.setLeft(null);
            list.add(root);
            root = root.getRight();
        }

        for (int i = 0; i < list.size() - 1; ++i) {
            list.get(i).setRight(list.get(i + 1));
        }

        return list.get(0);
    }
}
