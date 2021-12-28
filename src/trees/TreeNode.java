package trees;

public class TreeNode<E> {

    private E val;
    private TreeNode<E> left;
    private TreeNode<E> right;

    private TreeNode(){}

    public TreeNode(E val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(E val, TreeNode<E> left, TreeNode<E> right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public E getVal() {
        return val;
    }

    public void setVal(E val) {
        this.val = val;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }


}
