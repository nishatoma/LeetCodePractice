package binarysearch;

public class SplitArrayLargestSum_410 {

    public int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;

        for (int num : nums) {
            start = Math.max(start, num);
            end += num;
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            int sum = 0;
            int p = 1;

            for (int num: nums) {
                if (sum + num > mid) {
                    sum = num;
                    p++;
                } else {
                    sum += num;
                }
            }

            if (p > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }
}
