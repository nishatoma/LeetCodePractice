package binarysearch;

public class LC852 {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length, lo = 0, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= arr[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
