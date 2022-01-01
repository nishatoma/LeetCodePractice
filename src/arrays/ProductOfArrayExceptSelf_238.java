package arrays;

class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        // prefix the result array first
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        int right = 1;
        // instead of creating prefix and postfix, just
        // store the post-fix in a variable!!
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }

        return result;
    }
}