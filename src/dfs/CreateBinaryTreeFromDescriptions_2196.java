package dfs;

import trees.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTreeFromDescriptions_2196 {

    public TreeNode<Integer> createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode<Integer>> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            int isLeft = desc[2];


            TreeNode<Integer> pNode = map.getOrDefault(parent, new TreeNode<>(parent));


            children.add(child);

            if (isLeft == 1) {
                pNode.setLeft(map.getOrDefault(child, new TreeNode<>(child)));
                map.put(child, pNode.getLeft());
            } else {
                pNode.setRight(map.getOrDefault(child, new TreeNode<>(child)));
                map.put(child, pNode.getRight());
            }

            map.put(parent, pNode);
        }

        int root = -1;
        for (int[] desc : descriptions) {
            if (!children.contains(desc[0])) {
                root = desc[0];
                break;
            }
        }


        return map.getOrDefault(root, null);


    }

}
