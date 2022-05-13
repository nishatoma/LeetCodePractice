package dfs;

import java.util.*;

public class NaryTreePostOrderTraversal_590 {


//    public List<Integer> postorder(Node root) {
//        List<Integer> res = new ArrayList<>();
//
//        if (root == null) return res;
//
//        Deque<Node> stack = new ArrayDeque<>();
//        Deque<Node> stack2 = new ArrayDeque<>();
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            Node curr = stack.pop();
//            stack2.push(curr);
//
//            for (Node child: curr.children) stack.push(child);
//
//        }
//
//        while (!stack2.isEmpty()) {
//            res.add(stack2.pop().val);
//        }
//
//
//        return res;
//    }
}
