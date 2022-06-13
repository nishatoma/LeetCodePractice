package twopointers;

public class PartitionArrayAccordingToGivenPivot_2161 {

    public int[] pivotArray(int[] nums, int pivot) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[nums.length];
        // Go through the array with 4 pointers
        for (int i = 0, j = nums.length - 1; i < nums.length; ++i, --j) {
            // if the number from the left is < pivot, put it on the left side
            // of the result array
            if (nums[i] < pivot) {
                res[left++] = nums[i];
            }
            // if the number from the right side is bigger than pivot, put
            // it on the right side of the answer array
            if (nums[j] > pivot) {
                res[right--] = nums[j];
            }
        }
        // While there are elements remainging,
        // it means there are elements equal to pivot
        while (left <= right) {
            res[left++] = pivot;
        }

        return res;
    }
}
