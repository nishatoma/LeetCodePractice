package binarysearch;

public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 3, 2, 0};

        System.out.println(peakIndexInMountainArray(arr));
    }

    static int peakIndexInMountainArray(int[] arr) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (mid > 0 && mid < arr.length && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > 0 && arr[mid] > arr[mid - 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return -1;
    }
}
