package backtracking;

import java.util.ArrayList;
import java.util.List;

class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {

        // Have a result list
        List<List<Integer>> perms = new ArrayList<>();
        perms.add(new ArrayList<>());

        for (int num : nums) {
            int s = perms.size();


            for (int i = 0; i < s; i++) {
                List<Integer> list = new ArrayList<>(perms.get(i));
                list.add(num);
                perms.add(list);
            }
        }

        return perms;
    }
}
