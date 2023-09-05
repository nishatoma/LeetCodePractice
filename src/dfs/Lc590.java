package dfs;


import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Lc590 {

//    public List<Integer> postorder(TreeNode root) {
//        LinkedList<Integer> res = new LinkedList<>();
//        if (root == null) {
//            return res;
//        }
//
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//
//            for (TreeNode child : node.children) {
//                stack.push(child);
//            }
//            res.addFirst(node.val);
//        }
//        return res;
//    }
}
