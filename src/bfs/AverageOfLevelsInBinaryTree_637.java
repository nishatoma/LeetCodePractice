package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AverageOfLevelsInBinaryTree_637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        Deque<TreeNode> q = new ArrayDeque<>();
        q.push(root);

        while (!q.isEmpty()) {
            int n = q.size();
            double sum = 0.0;
            int cnt = 0;

            while (n-- != 0) {
                TreeNode<Integer> curr = q.poll();
                // Get value and add it to sum
                sum += curr.getVal();
                // Increase count
                cnt++;

                if (curr.getLeft() != null) q.offer(curr.getLeft());
                if (curr.getRight() != null) q.offer(curr.getRight());
            }
            // Get the average and add it to the result
            res.add(sum / cnt);
        }

        return res;
    }
}
