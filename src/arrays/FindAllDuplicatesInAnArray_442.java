package arrays;

import java.util.ArrayList;
import java.util.List;

class FindAllDuplicatesInAnArray_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);

            if (nums[num - 1] < 0) {
                result.add(num);
            } else {
                nums[num - 1] *= -1;
            }
        }
        return result;
    }
}
