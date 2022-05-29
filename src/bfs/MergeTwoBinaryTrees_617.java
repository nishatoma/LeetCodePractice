package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MergeTwoBinaryTrees_617 {

    public TreeNode<Integer> mergeTrees(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        Deque<TreeNode<Integer>[]> q = new ArrayDeque<>();

        q.push(new TreeNode<>[]{root1, root2});

        while (!q.isEmpty()) {
            TreeNode<Integer>[] currLevel = q.poll();

            if (currLevel[0] == null || currLevel[1] == null) continue;

            currLevel[0].setVal(currLevel[1].getVal());

            if (currLevel[0].getLeft() == null) {
                currLevel[0].setLeft(currLevel[1].getLeft());
            } else {
                q.push(new TreeNode<>[]{currLevel[0].getLeft(), currLevel[1].getLeft()});
            }

            if (currLevel[0].getRight() == null) {
                currLevel[0].setRight(currLevel[1].getRight());
            } else {
                q.push(new TreeNode[]{currLevel[0].getRight(), currLevel[1].getRight()});
            }
        }

        return root1;
    }
}
