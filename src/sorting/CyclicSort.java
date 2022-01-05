package sorting;

import java.util.Arrays;
import java.util.List;

public class CyclicSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        performCyclicSort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
//        List.of(nums).forEach(System.out::println);
    }


    static void performCyclicSort(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            int correctIndex = nums[i] - 1;

            if (i != correctIndex) {
                int tmp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = tmp;
            } else {
                i++;
            }
        }
    }
}


