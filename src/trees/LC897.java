package trees;

import java.util.ArrayList;
import java.util.List;

public class LC897 {
    public TreeNode increasingBST(TreeNode root) {
        // base case
        if (root == null) {
            return root;
        }
        // Get the list from root
        List<TreeNode> list = getList(root, new ArrayList<>());
        // System.out.println(list);
        // Make a new tree node
        TreeNode parent = new TreeNode(0);
        // Visit the rest
        TreeNode curr = parent;
        for (int i = 0; i < list.size(); ++i) {
            curr.right = new TreeNode(list.get(i).val);
            curr = curr.right;
        }
        return parent.right;
    }

    // Make a list in order
    private List<TreeNode> getList(TreeNode root, List<TreeNode> curr) {
        if (root == null) {
            return curr;
        }
        getList(root.left, curr);
        curr.add(root);
        getList(root.right, curr);
        return curr;
    }
}
