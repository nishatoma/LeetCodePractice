package binarysearch;

class BinarySearch_704 {
    public int search(int[] nums, int target) {

        int result = -1;

        if (nums.length == 0) {
            return result;
        }

        int left = 0;
        int right = nums.length - 1;


        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}