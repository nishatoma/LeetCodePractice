package backtracking;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {

    public List<String> binaryTreePaths(TreeNode<String> root) {
        List<String> res = new ArrayList<>();

        helper(res, root, new StringBuilder());

        return res;
    }

    private void helper(List<String> res, TreeNode<String> root, StringBuilder sb) {
        if (root == null) return;
        // Get the original length so we can restore later
        int len = sb.length();
        // Append root value to the string builder
        sb.append(root.getVal());

        if (root.getLeft() == null && root.getRight() == null) {
            // We reached the end, just append sb
            res.add(sb.toString());
        } else {
            // Explore the rest of the tree
            sb.append("->");
            helper(res, root.getLeft(), sb);
            helper(res, root.getRight(), sb);
        }
        // remove from string builder
        sb.setLength(len);
    }
}
