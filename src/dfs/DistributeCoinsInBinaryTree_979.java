package dfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class DistributeCoinsInBinaryTree_979 {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(4);
        root.setLeft(new TreeNode<>(0));
        root.getLeft().setLeft(new TreeNode<>(0));
        root.setRight(new TreeNode<>(0));

        distributeCoins(root);
    }

    private static int distributeCoins(TreeNode<Integer> root) {
        int ans = 0;

        if (root == null) return ans;

        Deque<TreeNode<Integer>> stack1 = new ArrayDeque<>();
        Deque<TreeNode<Integer>> stack2 = new ArrayDeque<>();

        Map<TreeNode<Integer>, Integer> map = new HashMap<>();
        map.put(null, 0);


        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode<Integer> curr = stack1.pop();
            stack2.push(curr);

            if (curr.getLeft() != null) {
                stack1.push(curr.getLeft());
            }

            if (curr.getRight() != null) {
                stack1.push(curr.getRight());
            }
        }

        while (!stack2.isEmpty()) {
            TreeNode<Integer> curr = stack2.pop();
            int coins = map.get(curr.getLeft()) + map.get(curr.getRight()) + curr.getVal() - 1;
            ans += Math.abs(coins);
            map.put(curr, coins);
        }


        return ans;
    }
}
