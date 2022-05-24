package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountGoodNodesInBinaryTree_1448 {

//    public int goodNodes(TreeNode<Integer> root) {
//        if (root == null) {
//            return 0;
//        }
//
//        Deque<Pair<TreeNode<Integer>, Integer>> stack = new ArrayDeque<>();
//        int res = 0;
//
//        stack.push(new Pair<>(root, Integer.MIN_VALUE));
//
//
//        while (!stack.isEmpty()) {
//            Pair<TreeNode<Integer>, Integer> pair = stack.pop();
//            TreeNode<Integer> curr = pair.getFirst();
//            int max = pair.getSecond();
//
//            if (curr.getVal() >= max) {
//
//                max = curr.getVal();
//                res++;
//            }
//
//
//            if (curr.getRight() != null) {
//                stack.push(new Pair<>(curr.getRight(), Math.max(curr.getRight().getVal(), max)));
//            }
//
//            if (curr.getLeft() != null) {
//                stack.push(new Pair<>(curr.getLeft(), Math.max(curr.getLeft().getVal(), max)));
//            }
//        }
//
//        return res;
//    }
}
