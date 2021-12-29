package trees;

class PathSum_112 {
    public boolean hasPathSum(TreeNode<Integer> root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.getLeft() == null && root.getRight() == null && root.getVal() == targetSum) {
            return true;
        }

        return hasPathSum(root.getLeft(), targetSum - root.getVal()) || hasPathSum(root.getRight(), targetSum - root.getVal());
    }
}