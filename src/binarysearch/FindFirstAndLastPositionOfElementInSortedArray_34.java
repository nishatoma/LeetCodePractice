package binarysearch;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {

    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int first = search(nums, target, true);
        int second = search(nums, target, false);

        return new int[]{first, second};
    }

    private static int search(int[] nums, int target, boolean isLookingForStartIndex) {
        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                answer = mid;
                if (isLookingForStartIndex) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
