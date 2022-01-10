package binarysearch;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {

    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {


        int left = 0;
        int right = nums.length - 1;
        int firstFound = -1;
        int secondFound = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                // potential answer found
                if (mid > 0 && nums[mid] == nums[mid - 1]) {
                    // search left!
                    right = mid - 1;
                } else {
                    firstFound = mid;
                    break;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                // potential answer found
                if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                    // search right!
                    left = mid + 1;
                } else {
                    secondFound = mid;
                    break;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[]{firstFound, secondFound};
    }
}
