package trees;

class SubTreeOfAnotherTree_572 {
    public boolean isSubtree(TreeNode<Integer> root, TreeNode<Integer> subRoot) {

        if (root == null) {
            return false;
        }

        if (subRoot == null) {
            return true;
        }

        if (sameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.getLeft(), subRoot) || isSubtree(root.getRight(), subRoot);
    }

    boolean sameTree(TreeNode<Integer> left, TreeNode<Integer> right) {
        if (right == null && left == null) {
            return true;
        }

        if (right == null || left == null) {
            return false;
        }

        if (left.getVal() == right.getVal()) {
            return sameTree(left.getLeft(), right.getLeft()) && sameTree(left.getRight(), right.getRight());
        }

        return false;
    }

}