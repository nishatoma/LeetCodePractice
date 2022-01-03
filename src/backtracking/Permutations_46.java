package backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        // BFS with a queue approach
        List<List<Integer>> result = new ArrayList<>();

        Deque<List<Integer>> q = new ArrayDeque<>();
        q.offer(new ArrayList<>());

        for (int num : nums) {
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                List<Integer> prev = q.poll();

                for (int j = 0; j <= prev.size(); j++) {
                    List<Integer> curr = new ArrayList<>(prev);
                    curr.add(j, num);

                    if (curr.size() == nums.length) {
                        result.add(curr);
                    } else {
                        q.offer(curr);
                    }
                }
            }
        }
        return result;
    }
}