import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {


    public static void main(String[] args) {


        int[] nums1 = new int[]{1, 2, 3, 4, 5, 1};
        System.out.println(hasDuplicates(nums1));
        int[] nums2 = new int[]{1, 1, 2, 3, 4, 5, 6};
        System.out.println(hasDuplicates(nums2));

    }

    public static boolean hasDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
