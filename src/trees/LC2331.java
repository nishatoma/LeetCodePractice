package trees;

public class LC2331 {
    public boolean evaluateTree(TreeNode root) {
        // Base case
        return true;
    }

    public boolean evaluateTreeRecursive(TreeNode root) {
        // perhaps we can use a post-order traversal here?
        // idea is once we know the value of left and right, we look at the value of the
        // root, then we can decide it's and or etc..
        if (root.left == null) {
            return (int) root.val == 1;
        }
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        // Check root condition
        if ((int) root.val == 2) {
            // OR the conditions
            return left || right;
        }
        // AND condition
        return left && right;
    }
}
