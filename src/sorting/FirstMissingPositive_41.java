package sorting;

class FirstMissingPositive_41 {

    public int firstMissingPositive(int[] nums) {
        int k = 0;
        while (k < nums.length) {
            int correctIndex = nums[k] - 1;

            if (nums[k] > 0 && nums[k] < nums.length && nums[k] != nums[correctIndex]) {
                int tmp = nums[k];
                nums[k] = nums[correctIndex];
                nums[correctIndex] = tmp;
            } else {
                k++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}