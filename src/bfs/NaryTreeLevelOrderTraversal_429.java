package bfs;

import java.util.List;

public class NaryTreeLevelOrderTraversal_429 {

    // BFS traversal N-ary tree
//    public List<List<Integer>> levelOrder(Node root) {
//        // Make a list to store the output
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) return res;
//
//        // Queue for BFS
//        Deque<Node> q = new ArrayDeque<>();
//        q.offer(root);
//
//        while (!q.isEmpty()) {
//            int n = q.size();
//
//            // Make a temporary list to store current level
//            List<Integer> curr = new ArrayList<>();
//            // Iterate through the level
//            while (n-- != 0) {
//                Node node = q.poll();
//                // For each node in this level, add it to the list
//                curr.add(node.val);
//                // Add children of this node to the queue to
//                // process next
//                for (Node child : node.children) {
//                    q.offer(child);
//                }
//            }
//            // add temporary list to the result list after we finished
//            // with this level
//            res.add(new ArrayList<>(curr));
//        }
//
//        return res;
//    }
}
