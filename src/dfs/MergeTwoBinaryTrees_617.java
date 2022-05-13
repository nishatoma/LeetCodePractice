package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MergeTwoBinaryTrees_617 {

    public TreeNode<Integer> mergeTrees(TreeNode<Integer> root1, TreeNode<Integer> root2) {

        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        Deque<TreeNode<Integer>[]> stack = new ArrayDeque<>();
        stack.push(new TreeNode<>[]{root1, root2});

        while (!stack.isEmpty()) {
            TreeNode<Integer>[] curr = stack.pop();

            if (curr[1] == null) continue;

            // Otherwise, just merge the two values if root2 is also not null
            curr[0].setVal(curr[1].getVal());

            // Now check if the root1 left is empty, then occupy it with root2 left,
            // other wise just push both unto the stack.
            if (curr[0].getLeft() == null) {
                curr[0].setLeft(curr[1].getLeft());
            } else {
                stack.push(new TreeNode<>[]{curr[0].getLeft(), curr[1].getLeft()});
            }

            // Same thing with the right child
            if (curr[0].getRight() == null) {
                curr[0].setRight(curr[1].getRight());
            } else {
                stack.push(new TreeNode<>[]{curr[0].getRight(), curr[1].getRight()});
            }

        }

        return root1;
    }
}
