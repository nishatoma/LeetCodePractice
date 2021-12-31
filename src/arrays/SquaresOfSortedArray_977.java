package arrays;

class SquaresOfSortedArray_977 {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        int negIndex = 0;
        int posIndex = nums.length - 1;

        for (int i = result.length - 1; i >= 0; i--){
            if (Math.abs(nums[posIndex]) > Math.abs(nums[negIndex])){
                result[i] = nums[posIndex] * nums[posIndex];
                posIndex--;
            } else {
                result[i] = nums[negIndex] * nums[negIndex];
                negIndex++;
            }
        }
        return result;
    }
}