package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class FindElements {

    Set<Integer> set;

    public FindElements(TreeNode<Integer> root) {
        set = new HashSet<>();

        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        root.setVal(0);
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<Integer> curr = stack.pop();
            set.add(curr.getVal());

            if (curr.getRight() != null) {
                curr.getRight().setVal(curr.getVal() * 2 + 2);
                stack.push(curr.getRight());
            }

            if (curr.getLeft() != null) {
                curr.getLeft().setVal(curr.getVal() * 2 + 1);
                stack.push(curr.getLeft());
            }
        }

    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
