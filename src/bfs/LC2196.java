package bfs;

import trees.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] desc: descriptions) {
            int parent = desc[0];
            int child = desc[1];
            boolean isLeft = desc[2] == 1;


            TreeNode node = map.getOrDefault(parent, new TreeNode(parent));
            children.add(child);

            if (isLeft) {
                node.left = map.getOrDefault(child, new TreeNode(child));
                map.put(child, node.left);
            } else {
                node.right = map.getOrDefault(child, new TreeNode(child));
                map.put(child, node.right);
            }

            map.put(parent, node);
        }

        int root = -1;
        for (int key : map.keySet()) {
            if (!children.contains(key)) {
                root = key;
                break;
            }
        }

        return map.get(root);
    }
}
