package trees;

import java.util.List;

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

        // Now make a list:
        List<TreeNode<Integer>> list = TreeNode.breadthFirstValues(a);
//        list.forEach(item -> System.out.println(item.getVal()));
        // Find # 7
        System.out.println("Does #9 exist?: " + TreeNode.findNodeDfsRecursive(a, 9));
        System.out.println("Does #3 exist?: " + TreeNode.findNodeDfsRecursive(a, 3));
        System.out.println("Does #5 exist?: " + TreeNode.findNodeDfsRecursive(a, 5));
        System.out.println("Does #1 exist?: " + TreeNode.findNodeDfsRecursive(a, 1));
        // Total sum test
        System.out.println("Total sum using DFS Iterative: " + TreeNode.getTreeSumDFS(a));
        System.out.println("Total sum using DFS Recursive: " + TreeNode.getTreeSumDfsRecursive(a));
        System.out.println("Total sum using BFS Iterative: " + TreeNode.getTreeSumBfs(a));
        // Min value
        System.out.println("Min value using DFS Iterative: " + TreeNode.treeMinDFS(a));
        System.out.println("Min value using DFS Recursive: " + TreeNode.treeMinDfsRecursive(a));
        System.out.println("Min value using BFS Iterative: " + TreeNode.treeMinBFS(a));
        // Max value of root-to-leaf path sum
        System.out.println("Max value root to leaf sum DFS Iterative: "
                + TreeNode.getMaxRootToLeafPathSum(a));

    }
}
