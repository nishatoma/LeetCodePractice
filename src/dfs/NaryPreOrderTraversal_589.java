package dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NaryPreOrderTraversal_589 {

//    public List<Integer> preorder(Node root) {
//        List<Integer> res = new ArrayList<>();
//
//        if (root == null) return res;
//
//        Deque<Node> stack = new ArrayDeque<>();
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            Node curr = stack.pop();
//
//            res.add(curr.val);
//
//            for (int i = curr.children.size() - 1; i >= 0; --i) {
//
//                stack.push(curr.children.get(i));
//            }
//
//        }
//
//        return res;
//    }
}
