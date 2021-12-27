package Arrays;

import java.util.*;

public class FindAllNumsDisappearedInArray_448 {


    public static void main(String[] args) {

    }


    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer, Integer> completeNumbers = new HashMap<>();
        Map<Integer, Integer> numsMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        // Fill complete map with all numbers
        for (int i = 1; i <= nums.length; i++) {
            completeNumbers.put(i, i);
        }

        for (Integer key : completeNumbers.keySet()) {
            if (!numsMap.containsKey(key)) {
                result.add(key);
            }
        }

        return  result;

    }

}
