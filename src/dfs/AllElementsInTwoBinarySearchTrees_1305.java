package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees_1305 {

    public List<Integer> getAllElements(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        List<TreeNode<Integer>> list1 = new ArrayList<>();
        List<TreeNode<Integer>> list2 = new ArrayList<>();

        dfs(root1, list1);
        dfs(root2, list2);

        return merge(list1, list2);

    }

    private void dfs(TreeNode<Integer> root, List<TreeNode<Integer>> list) {

        if (root == null) return;

        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }

            root = stack.pop();
            list.add(root);
            root = root.getLeft();
        }
    }

    private List<Integer> merge(List<TreeNode<Integer>> list1, List<TreeNode<Integer>> list2) {


        int i = 0, j = 0;
        List<Integer> res = new ArrayList<>();

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).getVal() <= list2.get(j).getVal()) {
                res.add(list1.get(i++).getVal());
            } else {
                res.add(list2.get(j++).getVal());
            }
        }

        while (i < list1.size()) {
            res.add(list1.get(i++).getVal());
        }

        while (j < list2.size()) {
            res.add(list2.get(j++).getVal());
        }

        return res;
    }
}
