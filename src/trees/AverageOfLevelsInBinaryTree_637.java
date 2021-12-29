package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class AverageOfLevelsInBinaryTree_637 {
    public List<Double> averageOfLevels(TreeNode<Integer> root) {

        List<Double> result = new ArrayList<>();

        // Queue
        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        double sum = 0;
        double counter = 0.0;

        while (!queue.isEmpty()) {

            int n = queue.size();

            while(n-- != 0) {
                // then dequeue
                TreeNode<Integer> curr = queue.poll();

                sum += curr.getVal();
                counter++;

                if (curr.getLeft() != null) {
                    queue.add(curr.getLeft());
                }

                if (curr.getRight() != null) {
                    queue.add(curr.getRight());
                }


            }
            result.add(sum/counter);
            sum = 0;
            counter = 0;


        }
        return result;
    }
}
