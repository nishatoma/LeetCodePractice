package trees;

import java.util.HashSet;
import java.util.Set;

public class LC1457 {
    public int pseudoPalindromicPaths(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, set);
    }

    private int dfs(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return 0;
        }
        if (set.contains(root.val)) {
            set.remove(root.val);
        } else {
            set.add(root.val);
        }
        // leaf
        if (root.left == null && root.right == null) {
            return set.size() > 1 ? 0 : 1;
        }

        return dfs(root.left, new HashSet<>(set)) + dfs(root.right, new HashSet<>(set));
    }
}
