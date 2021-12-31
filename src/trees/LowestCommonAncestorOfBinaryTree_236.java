package trees;

class LowestCommonAncestorOfBinaryTree_236 {
    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null) {
            return null;
        }

        if (root.getVal() == p.getVal() || root.getVal() == q.getVal()){
            return root;
        }

        TreeNode<Integer> left = lowestCommonAncestor(root.getLeft(), p, q);
        TreeNode<Integer> right = lowestCommonAncestor(root.getRight(), p, q);

        if (left == null){
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }
}