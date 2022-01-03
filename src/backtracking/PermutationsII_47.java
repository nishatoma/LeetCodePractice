package backtracking;

import java.util.*;

class PermutationsII_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        backtrack(result, combo, nums, map);
        return result;
    }

    static void backtrack(List<List<Integer>> perms, List<Integer> combo, int[] nums, Map<Integer, Integer> map) {
        if (combo.size() == nums.length) {
            perms.add(new ArrayList<>(combo));
            return;
        }

        for (Integer num : map.keySet()) {
            int count = map.get(num);

            if (count == 0) {
                continue;
            }

            combo.add(num);
            map.put(num, count - 1);
            backtrack(perms, combo, nums, map);
            combo.remove(combo.size() - 1);
            map.put(num, count);
        }
    }

}
