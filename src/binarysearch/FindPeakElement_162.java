package binarysearch;

public class FindPeakElement_162 {

    public int findPeakElement(int[] nums) {
        int s = 0;
        int e = nums.length - 2;

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (nums[m] > nums[m + 1]) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return s;
    }
}
