package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC894 {
    public List<TreeNode> allPossibleFBT(int N) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        return dfs(N, map);
    }

    private List<TreeNode> dfs(int N, Map<Integer, List<TreeNode>> map) {
        if (map.containsKey(N)) return map.get(N);
        // Check N value
        List<TreeNode> list = new ArrayList<>();
        if (N == 1) {
            TreeNode node = new TreeNode(0);
            list.add(node);
            return list;
        } else if (N % 2 != 0) {
            // Iterate over even values
            for (int i = 2; i <= N; i += 2) {
                // Get left and right answers
                List<TreeNode> leftTree = dfs(i - 1, map);
                List<TreeNode> rightTree = dfs(N - i, map);
                // Iterate over both
                for (TreeNode left : leftTree) {
                    for (TreeNode right : rightTree) {
                        // Make a new node
                        TreeNode tree = new TreeNode(0);
                        // assign right and left
                        tree.left = clone(left);
                        tree.right = clone(right);
                        // add to result
                        list.add(tree);
                    }
                }
            }
        }
        map.put(N, list);
        return map.get(N);
    }

    private TreeNode clone(TreeNode tree) {
        if (tree == null) return null;
        TreeNode newTree = new TreeNode(tree.val);
        newTree.left = clone(tree.left);
        newTree.right = clone(tree.right);
        return newTree;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
