package trees;

import java.util.ArrayDeque;
import java.util.Deque;

class MergeTwoBinaryTrees_617 {
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

        Deque<TreeNode<Integer>[]> q = new ArrayDeque<>();

        q.add(new TreeNode[]{root1, root2});

        while (!q.isEmpty()) {
            TreeNode<Integer>[] nodes = q.poll();

            if (nodes[1] == null) {
                continue;
            }

            nodes[0].setVal(nodes[1].getVal());

            if (nodes[0].getLeft() == null){
                nodes[0].setLeft(nodes[1].getLeft());
            } else {
                q.add(new TreeNode[]{nodes[0].getLeft(), nodes[1].getRight()});
            }

            if (nodes[0].getRight() == null){
                nodes[0].setRight(nodes[1].getRight());
            } else {
                q.add(new TreeNode[]{nodes[0].getRight(), nodes[1].getRight()});
            }
        }

        return root1;
    }
}