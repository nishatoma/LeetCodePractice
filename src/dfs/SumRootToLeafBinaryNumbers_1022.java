package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumRootToLeafBinaryNumbers_1022 {

//    public int sumRootToLeaf(TreeNode<Integer> root) {
        // Keep track of both the node and current value
        // associated with it.
//        Deque<Pair<TreeNode<Integer>, Integer>> stack = new ArrayDeque<>();
//
//        int res = 0;
//        int val = 0;
//
//        stack.push(new Pair<>(root, val));
//
//        while (!stack.isEmpty()) {
//            Pair<TreeNode<Integer>, Integer> pair = stack.pop();
//            TreeNode<Integer> curr = pair.getFirst();
//
//            val = (pair.getSecond() << 1) | curr.getVal();
//
//            if (curr.getRight() == null && curr.getLeft() == null) {
//                res += val;
//            }
//
//            if (curr.getRight() != null) {
//                stack.push(new Pair<>(curr.getRight(), val));
//            }
//
//            if (curr.getLeft() != null) {
//                stack.push(new Pair<>(curr.getLeft(), val));
//            }
//        }
//
//        return res;
//    }

}
