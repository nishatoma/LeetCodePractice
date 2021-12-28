package trees;

public class TreeNodeApp {

    public static void main(String[] args) {
        TreeNode<Integer> a = new TreeNode<>(1);
        TreeNode<Integer> b = new TreeNode<>(2);
        TreeNode<Integer> c = new TreeNode<>(3);
        TreeNode<Integer> d = new TreeNode<>(4);
        TreeNode<Integer> e = new TreeNode<>(5);
        TreeNode<Integer> f = new TreeNode<>(6);
        TreeNode<Integer> g = new TreeNode<>(7);

        //   a
        //  / \
        // b   c
        a.setLeft(b);
        a.setRight(c);
        //    a
        //   / \
        //  b   c
        // /     \
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);
        c.setRight(g);
        BTreePrinter.printNode(a);
    }
}
