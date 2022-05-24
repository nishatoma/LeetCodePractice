package dfs;


import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumDepthOfNArryTree_559 {

//    public int maxDepth(Node root) {
//        if (root == null) return 0;
//
//        Deque<Pair<Node, Integer>> stack = new ArrayDeque<>();
//
//        int depth = 1;
//        stack.push(new Pair<>(root, depth));
//
//        while (!stack.isEmpty()) {
//            Pair<Node, Integer> pair = stack.pop();
//            Node curr = pair.getFirst();
//            depth = Math.max(depth, pair.getSecond());
//
//            for (Node child: curr.children) {
//                if (child != null) stack.push(new Pair<>(child, pair.getValue() + 1));
//
//            }
//        }
//
//        return depth;
//
//    }
}
