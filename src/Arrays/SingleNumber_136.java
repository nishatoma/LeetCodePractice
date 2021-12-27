package Arrays;

public class SingleNumber_136 {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 2, 3, 2, 4, 4};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {

        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;

    }
}
