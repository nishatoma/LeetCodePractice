package backtracking;

import java.util.*;

class SubsetsII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> perms = new ArrayList<>();
        perms.add(new ArrayList<>());

        int s = 0;
        int startIndex;

        for (int i = 0; i < nums.length; i++) {
            startIndex = (i > 0 && nums[i - 1] == nums[i] ? s : 0);
            s = perms.size();
            List<Integer> list;
            for (int j = startIndex; j < s; j++) {
                list = new ArrayList<>(perms.get(j));
                list.add(nums[i]);
                perms.add(list);
            }
        }
        return perms;
    }
}
