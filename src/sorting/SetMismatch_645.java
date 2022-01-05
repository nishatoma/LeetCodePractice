package sorting;

class SetMismatch_645 {
    public int[] findErrorNums(int[] nums) {

        int[] res = new int[]{-1, -1};

        int k = 0;
        while (k < nums.length) {
            int correctIndex = nums[k] - 1;

            if (nums[k] != nums[correctIndex]) {
                int tmp = nums[k];
                nums[k] = nums[correctIndex];
                nums[correctIndex] = tmp;
            } else {
                k++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res[0] = nums[i];
                res[1] = i + 1;
            }
        }
        return res;
    }
}
